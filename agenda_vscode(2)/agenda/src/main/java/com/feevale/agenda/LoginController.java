package com.feevale.agenda;

import javax.servlet.http.HttpSession;

import com.feevale.agenda.models.Usuario;
import com.feevale.agenda.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository rep;

    @RequestMapping("/login")
    public String index() {
        return ("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Usuario user, HttpSession session) {

        // Iterable<Usuario> userList = rep.findAll();
        Usuario possivelUsusrio = rep.findOneByEmail(user.getEmail());

        if (possivelUsusrio != null) {
            session.setAttribute("idUsuarioLogado", possivelUsusrio.getId());
            // msg = "Email cadastrado : " + possivelUsusrio.getEmail() + " - senha:" +
            // possivelUsusrio.getSenha();
        } else {

            return "redirect:/";
        }
        return "redirect:/usuarios";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {

        // remover session idUsuarioLogado
        session.removeAttribute("idUsuarioLogado");

        return "redirect:/login";
    }

}