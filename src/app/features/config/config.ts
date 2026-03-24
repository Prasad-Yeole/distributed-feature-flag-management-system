import { Component, signal, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ConfigService } from '../../core/services/config';
import { FeatureService } from '../../core/services/feature';

@Component({
  selector: 'app-config',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './config.html',
  styleUrl: './config.css'
})
export class ConfigComponent implements OnInit {

  private configService = inject(ConfigService);
  private featureService = inject(FeatureService);

  features = this.featureService.features;
  environments = signal<any[]>([]);

  selectedFeatureId = signal('');
  selectedEnvId = signal('');
  enabled = signal(true);
  rollout = signal(50);

  message = signal('');
  isError = signal(false);

  ngOnInit() {
    this.featureService.loadFeatures();

    this.configService.getEnvironments().subscribe(res => {
      this.environments.set(res);
    });
  }

  saveConfig() {
    const request = {
      featureId: this.selectedFeatureId(),
      envId: this.selectedEnvId(),
      enabled: this.enabled(),
      rollout: this.rollout()
    };

    this.configService.createConfig(request).subscribe({
      next: () => {
        this.message.set('Config saved successfully');
        this.isError.set(false);
      },
      error: (err) => {
        this.message.set('Error saving config');
        this.isError.set(true);
        console.error(err);
      }
    });
  }
}