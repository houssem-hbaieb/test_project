import { Component, OnInit, AfterViewInit, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser, CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Chart, ChartOptions, registerables } from 'chart.js';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-dashboard',
  standalone: true, // ✅ important pour Angular 19 standalone
  imports: [CommonModule, FormsModule], // ✅ ngClass, ngIf, ngModel
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit, AfterViewInit {
  userRole: string | null = null;

    constructor(private authService: AuthService) {}


  
  ngAfterViewInit(): void {
    throw new Error('Method not implemented.');
  }
 sidebarOpen = false;
  selectedOrder: number | null = null;
  newUser = { name: '', email: '', role: 'User' };
  stats = [
    { title: 'Total Users', value: '1,234', trend: 5, color: 'blue', icon: 'fa-users' },
    { title: 'Revenue', value: '$12,345', trend: -2, color: 'green', icon: 'fa-dollar-sign' },
    { title: 'Orders', value: '567', trend: 8, color: 'purple', icon: 'fa-shopping-cart' },
    { title: 'Growth', value: '23%', trend: 10, color: 'orange', icon: 'fa-chart-line' }
  ];
  orders = [
    { id: 1, customer: 'Jane Smith', amount: 199.99, status: 'Completed' },
    { id: 2, customer: 'John Doe', amount: 99.99, status: 'Pending' },
    { id: 3, customer: 'Alice Johnson', amount: 299.99, status: 'Cancelled' }
  ];
  activities = [
    { title: 'New user registered', time: '2 hours', color: 'blue', icon: 'fa-user-plus' },
    { title: 'Order #1234 placed', time: '4 hours', color: 'green', icon: 'fa-shopping-cart' },
    { title: 'Analytics updated', time: '6 hours', color: 'purple', icon: 'fa-chart-line' }
  ];

  // Chart configurations

  revenueChartOptions: ChartOptions<'line'> = {
    responsive: true,
    maintainAspectRatio: false
  };


  userChartOptions: ChartOptions<'pie'> = {
    responsive: true,
    maintainAspectRatio: false
  };

  ngOnInit() {

        this.userRole = this.authService.getUserRole();
            console.log('User role:', this.userRole);  // <-- Add this line


  }

  toggleSidebar() {
    this.sidebarOpen = !this.sidebarOpen;
  }

  addUser() {
    if (this.newUser.name && this.newUser.email && this.newUser.role) {
      console.log('Adding user:', this.newUser);
      // Reset form
      this.newUser = { name: '', email: '', role: 'User' };
    }
  }

  selectOrder(id: number) {
    this.selectedOrder = id;
  }

  viewOrder(id: number) {
    console.log('Viewing order:', id);
  }

  editOrder(id: number) {
    console.log('Editing order:', id);
  }

  deleteOrder(id: number) {
    console.log('Deleting order:', id);
    this.orders = this.orders.filter(order => order.id !== id);
  }
}
