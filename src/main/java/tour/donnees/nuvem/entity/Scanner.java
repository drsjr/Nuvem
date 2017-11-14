package tour.donnees.nuvem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="scanner")
public class Scanner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idScanner;
	
	@Column
	private String folderPath;
	
	@Column
	private Date  executionTime;

	public Long getIdScanner() {
		return idScanner;
	}

	public void setIdScanner(Long idScanner) {
		this.idScanner = idScanner;
	}

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

}
