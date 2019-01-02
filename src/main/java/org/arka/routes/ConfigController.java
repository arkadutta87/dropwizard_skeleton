package org.arka.routes;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.arka.configuration.ConfigService;
import org.arka.model.Author;
import org.arka.model.BookConfigV2;
import org.arka.model.BookConfigV3;
import org.arka.model.BookV2;
import org.arka.model.ReksioConfigV2;
import org.arka.model.Representation;
import org.arka.model.TestConfigV2;
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
  public Representation<TestConfigV2> getReskioConfig() {
    TestConfigV2 reksioConfig = configService.getReksioConfig();

//    TestConfigV2 configObject = new TestConfigV2();
//    configObject.setAwake(reksioConfig.awake());
//    configObject.setBirthYear(reksioConfig.birthYear());
//    configObject.setBornIn(reksioConfig.bornIn());
//    configObject.setFriends(reksioConfig.friends());
//    configObject.setGrades(reksioConfig.grades());
//    configObject.setHomepage(reksioConfig.homepage());

    return new Representation<TestConfigV2>(HttpStatus.OK_200, reksioConfig);
  }

  @GET
  @Path("/books")
  @Timed
  public Representation<BookConfigV3> getBookConfig() {
    BookConfigV3 bookV2 = configService.getBookV2();

//    BookConfigV2 configObject = new BookConfigV2();
//    List<BookConfigV2.Author> authors = new ArrayList<>();
//
//    List<Author> authors1 = bookV2.authors();
//    authors1.forEach(aAuthor -> {
//      BookConfigV2.Author author = new BookConfigV2.Author();
//      author.setId(aAuthor.id());
//      author.setDateOfBirth(aAuthor.dateOfBirth());
//      author.setName(aAuthor.name());
//      author.setNationality(aAuthor.nationality());
//
//      authors.add(author);
//    });
//
//    configObject.setAuthors(authors);
//    configObject.setId(bookV2.id());
//    configObject.setDateOfPublish(bookV2.dateOfPublish());
//    configObject.setTitle(bookV2.title());


    return new Representation<BookConfigV3>(HttpStatus.OK_200, bookV2);
  }
}

