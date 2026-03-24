import { Routes } from '@angular/router';
import { Dashboard } from './features/dashboard/dashboard';
import { ConfigComponent } from './features/config/config';
import { EvaluationComponent } from './features/evaluation/evaluation';
import { AuditComponent } from './features/audit/audit';

export const routes: Routes = [
    { path: '', component: Dashboard },
    { path: 'config', component: ConfigComponent },
    { path: 'evaluate', component: EvaluationComponent },
    { path: 'audit', component: AuditComponent}
];
