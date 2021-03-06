package io.eldermael.pulumi.k8s.app;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Controller("/config")
public class ConfigController {

  @Inject
  private ApplicationContext context;

  @Value("${io.eldermael.pulumi.app.config.entry}")
  private String entryValue;

  @Value("${io.eldermael.pulumi.app.secret.entry}")
  private String secretValue;

  @Value("${io.eldermael.object.serialized}")
  private String configFromObject;

  @Get(produces = MediaType.APPLICATION_JSON)
  public Object config() {
    return Map.ofEntries(
        Map.entry("config", this.entryValue),
        Map.entry("secret", this.secretValue),
        Map.entry("another_config", this.configFromObject)
    );

  }

}
