export interface ConfigRequest {
  featureId: string;
  envId: string;
  enabled: boolean;
  rollout: number;
}