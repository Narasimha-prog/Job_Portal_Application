package lnr.Job_Portal_Application.job.infrastructure.secondary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "authority")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorityEntity implements Serializable {

    @Id
    @Column(name = "name",length = 50)
    @Size(max = 50)
    private String name;



}
