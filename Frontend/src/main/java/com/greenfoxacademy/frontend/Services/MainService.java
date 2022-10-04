package com.greenfoxacademy.frontend.Services;

import com.greenfoxacademy.frontend.DTOs.*;
import com.greenfoxacademy.frontend.Entities.Doubling;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    public Object doubling(Integer input) {
        Doubling number = new Doubling(input);

            DTO dto = new DTO();
            dto.setReceived(number.getInput());
            dto.setResult(number.getResult());

            return dto;

    }

    public Object doublingError() {
        DTOError dtoError = new DTOError();
        dtoError.setError("Please provide an input!");

        return dtoError;
    }

    public Object greeter(String name, String title) {

        if (title == null && name != null) {
            DTOError dtoError = new DTOError();
            dtoError.setError("Please provide a title!");
            dtoError.setStatus(400);

            return dtoError;

        } else if (name == null && title != null){
            DTOError dtoError = new DTOError();
            dtoError.setError("Please provide a name!");
            dtoError.setStatus(400);

            return dtoError;

        } else if (name == null && title == null){
            DTOError dtoError = new DTOError();
            dtoError.setError("Please provide a name and a title!");
            dtoError.setStatus(400);

            return dtoError;

        } else {
            GreeterDTO greeterDTO = new GreeterDTO();

            greeterDTO.setWelcome_message("Oh, hi there " + name + ", my dear " + title + "!");

            return greeterDTO;
        }
    }

    public Object appendA(String appendable) {
        if (appendable == null) {
            DTOError dtoError = new DTOError();
            dtoError.setError("No word to append was provided");
            dtoError.setStatus(404);

            return dtoError;
        } else {
            AppendDTO appendDTO = new AppendDTO();
            appendDTO.setAppended(appendable + "a");

            return appendDTO;
        }
    }

    public Object doUntil(String operation, Until until) {
        DoUntilDTO doUntilDTO = new DoUntilDTO();

        if(operation.equals("sum")) {
            Integer result = 0;
            for (int i = 0; i < until.getUntil(); i++) {
                result = result + (i+1);
            }
            doUntilDTO.setResult(result);
            return doUntilDTO;
        } else if (operation.equals("factor")) {
            Integer result = 1;
            for (int i = 0; i < until.getUntil(); i++) {
                result = result * (i+1);
            }
            doUntilDTO.setResult(result);
            return doUntilDTO;
        } else {
            DTOError dtoError = new DTOError();
            dtoError.setError("Please provide a number!");
            dtoError.setStatus(404);

            return dtoError;
        }
    }

}
