package com.adicse.eleccion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.Usuario;
import com.adicse.eleccion.repo.IUsuarioDao;


@Transactional
@Service
public class UsuarioService implements IAdicseService<Usuario, Integer>, UserDetailsService {
	
	@Autowired
	private IUsuarioDao iUsuarioDao;

	@Override
	public Page<Usuario> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getallbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario create(Usuario entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Usuario entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletebyid(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuario> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(username == null) {
			//logger.error("No Existe el usuario");
			
		}

		Usuario usuario = iUsuarioDao.findAllByLogin(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		UserDetails user = new User(username, usuario.getClave(), true , true, true, true, authorities);
		return user;
	}

}
