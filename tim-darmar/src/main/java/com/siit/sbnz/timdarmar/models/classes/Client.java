package com.siit.sbnz.timdarmar.models.classes;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Getter @Setter @NoArgsConstructor
public abstract class Client implements UserDetails{
	private static final long serialVersionUID = 1L;

	@Version
    @Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
    private Long version;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String role;
	
	@Column(nullable = false)
	private boolean blocked;
	
	@Column(nullable = false)
	private boolean deleted;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "client_authority",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
