import { Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Feature } from '../../models/feature.model';
import { CreateFeature } from '../../models/create-feature.model';

@Injectable({
  providedIn: 'root'
})
export class FeatureService {

  private baseUrl = 'http://localhost:8080/api/features';

  // SIGNAL (state)
  features = signal<Feature[]>([]);

  constructor(private http: HttpClient) {}

  // FETCH FEATURES
  loadFeatures() {
    this.http.get<Feature[]>(this.baseUrl)
      .subscribe({
        next: (data) => this.features.set(data),
        error: (err) => console.error(err)
      });
  }

  createFeature(feature: CreateFeature) {
  return this.http.post<any>(this.baseUrl, feature);
  }

  updateFeature(id: string, feature: CreateFeature) {
    return this.http.put<Feature>(`${this.baseUrl}/${id}`, feature);
  }

  deleteFeature(id: string) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}