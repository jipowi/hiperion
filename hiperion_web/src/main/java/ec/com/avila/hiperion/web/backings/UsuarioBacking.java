package ec.com.avila.hiperion.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Menu;
import ec.com.avila.hiperion.emision.entities.Rol;
import ec.com.avila.hiperion.emision.entities.RolMenu;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.servicio.UsuarioService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;

@ManagedBean
@SessionScoped
public class UsuarioBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private UsuarioService usuarioServicio;

	private MenuModel menumodel = new DefaultMenuModel();
	List<Menu> menuList = new ArrayList<>();

	Logger log = Logger.getLogger(UsuarioBacking.class);

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	/**
	 * 
	 * <b> Permite autenticar el usuario con la aplicacion </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 6, 2014]
	 * </p>
	 * 
	 * @param actionEvent
	 * @return
	 * @throws HiperionException
	 */
	public String login(ActionEvent actionEvent) throws HiperionException {
		menumodel = new DefaultMenuModel();
		menuList = new ArrayList<>();

		try {
			String salida = HiperionMensajes.getInstancia().getString("valor.navigation.error");

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage msg = null;
			boolean loggedIn;

			Usuario usuario;

			usuario = usuarioServicio.loginUser(usuarioBean.getNombreUsuario(), usuarioBean.getPassword());

			if (usuario != null) {
				loggedIn = true;
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioBean.getNombreUsuario());
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", usuarioBean.getNombreUsuario());
				salida = HiperionMensajes.getInstancia().getString("valor.navigation.main");
			} else {
				loggedIn = false;
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
			}

			// Consultar Roles por usuario
			List<Rol> roles = usuarioServicio.consultarRolByUsuario(usuario);
			// Consultar Menu por roles
			for (Rol rol : roles) {
				List<RolMenu> listRolMenus = usuarioServicio.consultarRolMenus(rol);
				for (RolMenu rolMenu : listRolMenus) {
					menuList.add(rolMenu.getMenu());
				}
			}

			// Agregar menus para el usuario
			List<Menu> listMenuPadres = new ArrayList<>();
			for (Menu menuPadre : menuList) {
				if (menuPadre.getIdPadre() == null) {
					listMenuPadres.add(menuPadre);
				}
			}

			for (Menu menuPadre : listMenuPadres) {
				DefaultSubMenu firstSubmenu = new DefaultSubMenu(menuPadre.getNombreMenu());
				for (Menu menuHijos : menuList) {
					if (menuHijos.getIdPadre() == menuPadre.getIdMenu()) {
						DefaultMenuItem menuItem = new DefaultMenuItem(menuHijos.getNombreMenu());
						menuItem.setUrl(menuHijos.getUrl());

						firstSubmenu.addElement(menuItem);
					}
				}
				menumodel.addElement(firstSubmenu);
			}

			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("loggedIn", loggedIn);

			usuarioBean.setSessionUser(usuario);

			return salida;

		} catch (HiperionException e) {
			log.error("Error al momento de hacer login", e);
			throw new HiperionException(e);
		}

	}

	/**
	 * @return the menumodel
	 */
	public MenuModel getMenumodel() {
		return menumodel;
	}

	/**
	 * @param menumodel
	 *            the menumodel to set
	 */
	public void setMenumodel(MenuModel menumodel) {
		this.menumodel = menumodel;
	}

	/**
	 * @return the menuList
	 */
	public List<Menu> getMenuList() {
		return menuList;
	}

	/**
	 * @param menuList
	 *            the menuList to set
	 */
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

}
