package org.arka.routes;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.arka.configuration.ConfigService;
import org.arka.model.ReksioConfig;
import org.arka.model.Representation;
import org.arka.model.TestConfig;
import org.eclipse.jetty.http.HttpStatus;

@Path("/config")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class ConfigController {

  @Inject
  private ConfigService configService;

  public ConfigController() {
  }

  @GET
  @Timed
  public Representation<TestConfig> getReskioConfig() {
    ReksioConfig reksioConfig = configService.getReksioConfig();

    TestConfig configObject = new TestConfig();
    configObject.setAwake(reksioConfig.awake());
    configObject.setBirthYear(reksioConfig.birthYear());
    configObject.setBornIn(reksioConfig.bornIn());
    configObject.setFriends(reksioConfig.friends());
    configObject.setGrades(reksioConfig.grades());
    configObject.setHomepage(reksioConfig.homepage());

    return new Representation<TestConfig>(HttpStatus.OK_200, configObject);
  }
}

