import { Component, signal } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css'
})
export class Navbar {

  menuOpen = signal(false);

  // 🌙 DARK MODE STATE
  isDark = signal(false);

  toggleMenu() {
    this.menuOpen.update(v => !v);
  }

  toggleTheme() {
  this.isDark.set(!this.isDark());

  document.body.classList.toggle('dark-theme');
}
}
