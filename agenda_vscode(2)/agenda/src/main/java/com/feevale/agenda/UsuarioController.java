package com.feevale.agenda;

import java.util.ArrayList;
import java.util.List;

import com.feevale.agenda.dto.UsuarioDTO;
import com.feevale.agenda.models.Usuario;
import com.feevale.agenda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository rep;

    @RequestMapping("/usuarios")
    public ModelAndView lista() {

        Iterable<Usuario> listaUsuarios = rep.findAll();
        List<UsuarioDTO> listaDTO = new ArrayList<UsuarioDTO>();// = new List<UsuarioDTO>();
        for (Usuario usuario : listaUsuarios) {
            listaDTO.add(new UsuarioDTO(usuario));
        }

        ModelAndView model = new ModelAndView("usuarios");
        model.addObject("users", listaDTO);

        return (model);
    }

    @RequestMapping("/cadastraUsuario")
    public String cadastra() {

        return ("cadastraUsuario");
    }

    @RequestMapping(value = "/cadastraUsuario", method = RequestMethod.POST)
    public String cadastra(Usuario user) {
        rep.save(user);

        return "redirect:/usuarios";
    }
}