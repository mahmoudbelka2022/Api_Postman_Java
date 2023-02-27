package FastTrack4Api.POJO;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Search {

    private List<Spartan> content;
    private int totalElement;
}
