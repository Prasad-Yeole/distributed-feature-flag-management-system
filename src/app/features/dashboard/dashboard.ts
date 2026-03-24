import { Component, OnInit, inject, signal } from '@angular/core';
import { FeatureService } from '../../core/services/feature';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard implements OnInit {

  private featureService = inject(FeatureService);

  // FEATURE LIST
  features = this.featureService.features;

  // FORM SIGNALS
  name = signal('');
  description = signal('');
  owner = signal('');
  active = signal(true);

  // EDIT MODE
  editingId = signal<string | null>(null);

  message = signal('');

  ngOnInit() {
    this.featureService.loadFeatures();
  }

  // CREATE OR UPDATE
  saveFeature() {
    const payload = {
      name: this.name(),
      description: this.description(),
      owner: this.owner(),
      active: this.active()
    };

    // UPDATE
    if (this.editingId()) {
      this.featureService.updateFeature(this.editingId()!, payload).subscribe({
        next: () => {
          this.message.set('Feature updated successfully');
          this.resetForm();
          this.featureService.loadFeatures();
        },
        error: (err) => {
          this.message.set('Error updating feature');
          console.error(err);
        }
      });
    } 
    // CREATE
    else {
      this.featureService.createFeature(payload).subscribe({
        next: () => {
          this.message.set('Feature created successfully');
          this.resetForm();
          this.featureService.loadFeatures();
        },
        error: (err) => {
          this.message.set('Error creating feature');
          console.error(err);
        }
      });
    }
  }

  // EDIT FEATURE
  editFeature(feature: any) {
    this.editingId.set(feature.id);

    this.name.set(feature.name);
    this.description.set(feature.description);
    this.owner.set(feature.owner);
    this.active.set(feature.active);
  }

  // DELETE FEATURE
  deleteFeature(id: string) {
    this.featureService.deleteFeature(id).subscribe({
      next: () => {
        this.message.set('Feature deleted');
        this.featureService.loadFeatures();
      },
      error: (err) => {
        this.message.set('Error deleting feature');
        console.error(err);
      }
    });
  }

  // RESET FORM
  resetForm() {
    this.editingId.set(null);
    this.name.set('');
    this.description.set('');
    this.owner.set('');
    this.active.set(true);
  }
}