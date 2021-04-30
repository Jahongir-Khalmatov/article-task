package lesson7.articletask.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class ResurceNotFoundException extends RuntimeException {
  final   private String resourceName;//lavozim
    final private String resourceField;//name
    final private Object object;//User,Admin,1,29
}
