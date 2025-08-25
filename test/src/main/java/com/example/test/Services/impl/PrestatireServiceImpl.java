package com.example.test.Services.impl;

import com.example.test.Models.DebiteurCtx;
import com.example.test.Models.Prestataire;
import com.example.test.Models.TypePrestation;
import com.example.test.Repositories.DebiteurRepository;
import com.example.test.Repositories.PrestataireRepository;
import com.example.test.Services.PrestatireService;
import com.example.test.dto.PrestataireDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrestatireServiceImpl implements PrestatireService {

    private final PrestataireRepository prestataireRepository;
    private final DebiteurRepository debiteurRepository;
    @Override
    public PrestataireDTO create(PrestataireDTO dto) {
        DebiteurCtx debiteur = debiteurRepository.findByNumCtx(dto.getNumCtx())
                .orElseThrow(() -> new RuntimeException("Debiteur non trouvé"));

        String code = generateCode(dto.getTypeP());

        Prestataire prestataire = PrestataireDTO.toEntity(dto, debiteur);
        prestataire.setCodeP(code);

        Prestataire saved = prestataireRepository.save(prestataire);

        return PrestataireDTO.fromEntity(saved)  ;

    }

    @Override
    public PrestataireDTO findById(Long id) {
        return prestataireRepository.findById(id)
                .map(PrestataireDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Prestataire non trouvé"));    }


    public List<PrestataireDTO> findByDebiteurId(Long debiteurId) {
        return prestataireRepository.findByDebiteurCtx_numCtx(debiteurId)
                .stream()
                .map(PrestataireDTO::fromEntity)
                .toList();
    }

    @Override
    public List<PrestataireDTO> getAll() {
        return prestataireRepository.findAll()
                .stream()
                .map(PrestataireDTO::fromEntity)
                .toList();
    }

    @Override
    public PrestataireDTO update(Long id, PrestataireDTO dto) {
        Prestataire existing = prestataireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestataire non trouvé"));

        existing.setNomP(dto.getNomP());
        existing.setPrenomP(dto.getPrenomP());
        existing.setAdresse(dto.getAdresse());
        existing.setNumcpte(dto.getNumcpte());
        existing.setAgence(dto.getAgence());
        existing.setDateFiscale(dto.getDateFiscale());
        existing.setEmailP(dto.getEmailP());
        existing.setTypeP(dto.getTypeP());

        if (!existing.getTypeP().equals(dto.getTypeP())) {
            existing.setCodeP(generateCode(dto.getTypeP()));
        }

        Prestataire saved = prestataireRepository.save(existing);
        return PrestataireDTO.fromEntity(saved);
    }

    @Override
    public void delete(Long id) {

        prestataireRepository.deleteById(id);

    }



    private String generateCode(TypePrestation type) {
        Optional<Prestataire> lastPrestataire = prestataireRepository.findLastByType(type);

        int nextNumber = 1;
        if (lastPrestataire.isPresent()) {
            String lastCode = lastPrestataire.get().getCodeP();
            try {
                nextNumber = Integer.parseInt(lastCode.substring(1)) + 1;
            } catch (Exception ignored) {}
        }

        String prefix = switch (type) {
            case AVOCAT -> "A";
            case HUISSIER -> "H";
            case EXPERT -> "E";
        };

        return String.format("%s%03d", prefix, nextNumber);
    }
}
