package org.arka.routes;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.arka.model.Book;
import org.arka.model.Representation;
import org.arka.service.BooksService;
import org.eclipse.jetty.http.HttpStatus;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class BooksController {

  @Inject
  private BooksService booksService;

  public BooksController() {
  }

  @GET
  @Timed
  public Representation<List<Book>> getBooks() {
    return new Representation<List<Book>>(HttpStatus.OK_200, booksService.getBooks());
  }
}
