
package sistem.componentes;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("vlogin")
public class ValidacionesLogin implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String nombreUsuario = value.toString().trim();

        if (nombreUsuario.length() == 0) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "ingrese un usuario"));

        } else {
            String expresionesLetras="^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$";
            boolean aceptable=Pattern.matches(expresionesLetras,nombreUsuario);
            if(!aceptable){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "ingrese solo letras"));
            }
            
        }

    }

}
