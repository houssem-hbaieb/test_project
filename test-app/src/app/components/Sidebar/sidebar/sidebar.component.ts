import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../../services/auth.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  imports: [[CommonModule, FormsModule ,RouterModule] ],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss'
})
export class SidebarComponent implements OnInit {

      constructor(private authService: AuthService) {}
  


  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  sidebarOpen = false;

  toggleSidebar() {
    this.sidebarOpen = !this.sidebarOpen;
  }

  closeSidebar() {
    this.sidebarOpen = false;
  }

}
