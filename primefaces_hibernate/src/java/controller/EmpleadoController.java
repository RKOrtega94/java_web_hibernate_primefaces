package controller;

import model.Empleado;
import model.Usuario;
import java.util.Collection;
import facade.EmpleadoFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "empleadoController")
@ViewScoped
public class EmpleadoController extends AbstractController<Empleado> {

    @Inject
    private CargoController cargoIdController;
    @Inject
    private EmpresaController empresaIdController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isUsuarioCollectionEmpty;

    public EmpleadoController() {
        // Inform the Abstract parent controller of the concrete Empleado Entity
        super(Empleado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cargoIdController.setSelected(null);
        empresaIdController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsUsuarioCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Cargo controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCargoId(ActionEvent event) {
        Empleado selected = this.getSelected();
        if (selected != null && cargoIdController.getSelected() == null) {
            cargoIdController.setSelected(selected.getCargoId());
        }
    }

    /**
     * Sets the "selected" attribute of the Empresa controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEmpresaId(ActionEvent event) {
        Empleado selected = this.getSelected();
        if (selected != null && empresaIdController.getSelected() == null) {
            empresaIdController.setSelected(selected.getEmpresaId());
        }
    }

    public boolean getIsUsuarioCollectionEmpty() {
        return this.isUsuarioCollectionEmpty;
    }

    private void setIsUsuarioCollectionEmpty() {
        Empleado selected = this.getSelected();
        if (selected != null) {
            EmpleadoFacade ejbFacade = (EmpleadoFacade) this.getFacade();
            this.isUsuarioCollectionEmpty = ejbFacade.isUsuarioCollectionEmpty(selected);
        } else {
            this.isUsuarioCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Empleado and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioCollection() {
        Empleado selected = this.getSelected();
        if (selected != null) {
            EmpleadoFacade ejbFacade = (EmpleadoFacade) this.getFacade();
            Collection<Usuario> selectedUsuarioCollection = ejbFacade.findUsuarioCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", selectedUsuarioCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/usuario/index";
    }

}
