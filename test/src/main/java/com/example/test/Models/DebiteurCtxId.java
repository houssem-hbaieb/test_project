package com.example.test.Models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DebiteurCtxId implements Serializable {

    private static final long serialVersionUID = 1L;
    private int numCtx;
    private int codeStructureCtx;

}
