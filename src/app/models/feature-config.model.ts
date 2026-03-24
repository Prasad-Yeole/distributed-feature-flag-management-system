export interface FeatureConfig {
  featureName: string;
  environment: string;
  enabled: boolean;
  rolloutPercentage: number;
}