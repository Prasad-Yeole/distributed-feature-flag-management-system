import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigRequest } from '../../models/config.model';
import { FeatureConfig } from '../../models/feature-config.model';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private baseUrl = 'http://localhost:8080/api/v1/configs';

  constructor(private http: HttpClient) { }

  createConfig(request: ConfigRequest) {
    return this.http.post<FeatureConfig>(this.baseUrl, request);
  }

  getEnvironments() {
    return this.http.get<any[]>('http://localhost:8080/api/environments');
  }

  evaluateFeature(featureName: string, userId: string, env: string) {
  return this.http.get<any>(
    `http://localhost:8080/api/v1/features/evaluate?featureName=${featureName}&userId=${userId}&env=${env}`
    );
  }

}