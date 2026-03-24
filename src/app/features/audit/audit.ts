import { Component, signal, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuditService, AuditLog } from '../../core/services/audit';
import { FeatureService } from '../../core/services/feature';

@Component({
  selector: 'app-audit',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './audit.html',
  styleUrl: './audit.css'
})
export class AuditComponent implements OnInit {

  private auditService = inject(AuditService);
  private featureService = inject(FeatureService);

  // DATA
  logs = signal<AuditLog[]>([]);
  features = this.featureService.features;

  // FILTER
  selectedFeature = signal('');

  loading = signal(false);

  ngOnInit() {
    this.featureService.loadFeatures();
    this.loadLogs();
  }

  loadLogs() {
    this.loading.set(true);

    this.auditService.getLogs(this.selectedFeature()).subscribe({
      next: (res) => {
        this.logs.set(res);
        this.loading.set(false);
      },
      error: (err) => {
        console.error(err);
        this.loading.set(false);
      }
    });
  }

  onFeatureChange(event: any) {
    this.selectedFeature.set(event.target.value);
    this.loadLogs();
  }
}