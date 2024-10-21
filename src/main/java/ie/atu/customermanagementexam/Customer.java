package ie.atu.customermanagementexam;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name must not be blank")
    @Min(value = 2, message "First name must be at least 2 characters")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    @Min(value = 2, message = "Last name must be at least 2 characters")
    private String lastName

    @Email(regexp = "@atu.ie", message = "Email must be in valid format")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Past(message = "Date must not be in the future")
    private LocalDate dob;

    @Pattern(regexp = "^[A-Za-z]\\d{6}$", message = "Eircode must begin with a letter followed by 6 numbers")
    private String eircode;

    public boolean isAdult(){
        return Period.between(this.dob, LocalDate.now()).getYears() >= 18;
    }

}
