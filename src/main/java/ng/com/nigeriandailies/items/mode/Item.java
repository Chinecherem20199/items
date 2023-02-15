package ng.com.nigeriandailies.items.mode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "todo_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;


    @NotBlank(message = "Name is required")
    private String name;


    @NotBlank(message = "Description is required")
    private String description;
    private boolean complete;

    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date modifiedDate;


    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description='%s', complete='%s', createdDate='%s', modifiedDate='%s'}",
                id, description, complete, createdDate, modifiedDate);
    }


}
