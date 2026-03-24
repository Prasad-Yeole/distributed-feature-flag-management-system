import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface AuditLog {
  featureName: string;
  action: string;
  changedBy: string;
  timestamp: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuditService {

  private baseUrl = 'http://localhost:8080/api/audit-logs';

  constructor(private http: HttpClient) {}

  getLogs(featureName?: string): Observable<AuditLog[]> {
    if (featureName) {
      return this.http.get<AuditLog[]>(`${this.baseUrl}?featureName=${featureName}`);
    }
    return this.http.get<AuditLog[]>(this.baseUrl);
  }
}