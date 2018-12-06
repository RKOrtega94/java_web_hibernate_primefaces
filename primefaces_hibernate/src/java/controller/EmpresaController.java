package controller;

import model.Empresa;
import model.Empleado;
import java.util.Collection;
import facade.EmpresaFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "empresaController")
@ViewScoped
public class EmpresaController extends AbstractController<Empresa> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isEmpleadoCollectionEmpty;

    public EmpresaController() {
        // Inform the Abstract parent controller of the concrete Empresa Entity
        super(Empresa.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEmpleadoCollectionEmpty();
    }

    public boolean getIsEmpleadoCollectionEmpty() {
        return this.isEmpleadoCollectionEmpty;
    }

    private void setIsEmpleadoCollectionEmpty() {
        Empresa selected = this.getSelected();
        if (selected != null) {
            EmpresaFacade ejbFacade = (EmpresaFacade) this.getFacade();
            this.isEmpleadoCollectionEmpty = ejbFacade.isEmpleadoCollectionEmpty(selected);
        } else {
            this.isEmpleadoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Empleado entities that
     * are retrieved from Empresa and returns the navigation outcome.
     *
     * @return navigation outcome for Empleado page
     */
    public String navigateEmpleadoCollection() {
        Empresa selected = this.getSelected();
        if (selected != null) {
            EmpresaFacade ejbFacade = (EmpresaFacade) this.getFacade();
            Collection<Empleado> selectedEmpleadoCollection = ejbFacade.findEmpleadoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empleado_items", selectedEmpleadoCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/empleado/index";
    }

}
