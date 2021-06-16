package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="photo")
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name = "default_profile_photo";

    @Column(name = "url")
    private String url = "http://res.cloudinary.com/mahmud123/image/upload/v1623740303/rxzbmnwucaikmdjgoncx.png";

    @Column(name = "public_id")
    private String publicId = "rxzbmnwucaikmdjgoncx";
    
	@JsonIgnore
	@JoinColumn(name = "candidates_id")
	@ManyToOne
	private Candidate candidate;
	
    public Photo(int id, String name, String url, String publicId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.publicId = publicId;
        
    }
    
}
