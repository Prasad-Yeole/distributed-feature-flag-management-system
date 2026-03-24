import { Component, signal, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { FeatureService } from '../../core/services/feature';
import { ConfigService } from '../../core/services/config';

@Component({
  selector: 'app-evaluation',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './evaluation.html',
  styleUrl: './evaluation.css'
})
export class EvaluationComponent implements OnInit {

  private featureService = inject(FeatureService);
  private configService = inject(ConfigService);

  // DATA
  features = this.featureService.features;
  environments = signal<any[]>([]);

  // INPUTS
  selectedFeature = signal('');
  selectedEnv = signal('');
  userId = signal('');

  // OUTPUT
  result = signal<any | null>(null);
  loading = signal(false);
  error = signal('');

  ngOnInit() {
    this.featureService.loadFeatures();

    this.configService.getEnvironments().subscribe({
      next: (res) => this.environments.set(res),
      error: (err) => console.error(err)
    });
  }

  evaluate() {
    this.loading.set(true);
    this.error.set('');
    this.result.set(null);

    this.configService.evaluateFeature(
      this.selectedFeature(),
      this.userId(),
      this.selectedEnv()
    ).subscribe({
      next: (res) => {
        this.result.set(res);
        this.loading.set(false);
      },
      error: (err) => {
        this.error.set('Evaluation failed');
        this.loading.set(false);
        console.error(err);
      }
    });
  }
}