/**
 * App: registration
 * Package: com.bobwares.customer.registration
 * File: TracingConfig.java
 * Version: 0.1.1
 * Turns: 2
 * Author: Bobwares
 * Date: 2025-09-11T08:54:27Z
 * Exports: otlpExporter, openTelemetrySdk
 * Description: Configures Micrometer tracing with OpenTelemetry exporter.
 */
package com.bobwares.customer.registration;

import io.micrometer.tracing.exporter.otlp.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {

  @Bean
  OtlpGrpcSpanExporter otlpExporter() {
    return OtlpGrpcSpanExporter.builder()
        .setEndpoint(System.getenv().getOrDefault("OTEL_EXPORTER_OTLP_ENDPOINT", "http://localhost:4317"))
        .build();
  }

  @Bean
  OpenTelemetrySdk openTelemetrySdk(OtlpGrpcSpanExporter exporter) {
    var provider = SdkTracerProvider.builder()
        .addSpanProcessor(BatchSpanProcessor.builder(exporter).build())
        .build();
    return OpenTelemetrySdk.builder().setTracerProvider(provider).build();
  }
}
