package com.feevale.agenda;

import java.util.ArrayList;
import java.util.List;

import com.feevale.agenda.dto.ContatoDTO;
import com.feevale.agenda.models.Contato;
import com.feevale.agenda.models.ContatoEscolar;
import com.feevale.agenda.models.ContatoFamiliar;
import com.feevale.agenda.repository.ContatoEscolarRepository;
import com.feevale.agenda.repository.ContatoFamiliarRepository;
import com.feevale.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatoController {

    @Autowired
    private ContatoEscolarRepository repEsc;
    @Autowired
    private ContatoFamiliarRepository repFam;
    @Autowired
    private ContatoRepository repCont;

    @RequestMapping("/contatos")
    public ModelAndView lista() {
        List<ContatoDTO> contatos = new ArrayList<ContatoDTO>();

        for (Contato contato : repCont.findAll()) {
            contatos.add(new ContatoDTO(contato.getId(), contato.getNome(), contato.getApelido(), contato.getTelefone(),
                    contato instanceof ContatoFamiliar ? true : false));
        }
        ModelAndView modelContatos = new ModelAndView("contatos");
        modelContatos.addObject("contatos", contatos);
        return (modelContatos);
    }

    @RequestMapping("/cadastraFamiliar")
    public String cadastraFamiliar() {

        return ("contatoFamiliar/novoContatoFamiliar");
    }

    @RequestMapping(value = "/cadastraFamiliar", method = RequestMethod.POST)
    public String cadastraFamiliar(ContatoFamiliar user) {
        repFam.save(user);

        return "redirect:/contatos";
    }

    @RequestMapping("/cadastraEscolar")
    public String cadastraEscolar() {

        return ("contatoEscolar/novoContatoEscolar");
    }

    @RequestMapping(value = "/cadastraEscolar", method = RequestMethod.POST)
    public String cadastraEscolar(ContatoFamiliar user) {
        repFam.save(user);

        return "redirect:/contatos";
    }

    @RequestMapping(value = "/editaEscolar/{id}", method = RequestMethod.GET)
    public ModelAndView editaEscolar(@PathVariable(value = "id", required = true) int id) {
        ContatoEscolar contato = repEsc.findByid(id);
        ModelAndView model = new ModelAndView("contatoEscolar/edtContatoEscolar");
        model.addObject("contato", contato);

        return (model);
    }

    @RequestMapping(value = "/editaFamiliar/{id}", method = RequestMethod.GET)
    public ModelAndView editaFamiliar(@PathVariable("id") int id) {
        ContatoFamiliar contato = repFam.findByid(id);
        ModelAndView model = new ModelAndView("contatoFamiliar/edtContatoFamiliar");
        model.addObject("contato", contato);

        return (model);
    }

    @RequestMapping(value = "/editaFamiliar", method = RequestMethod.POST)
    public String editaFamiliar(ContatoFamiliar contato) {
        repFam.save(contato);

        return "redirect:/contatos";
    }

    @RequestMapping(value = "/editaEscolar", method = RequestMethod.POST)
    public String editaFamiliar(ContatoEscolar contato) {
        repEsc.save(contato);

        return "redirect:/contatos";
    }

    @RequestMapping(value = "/consultaEscolar/{id}", method = RequestMethod.GET)
    public ModelAndView consultaEscolar(@PathVariable(value = "id", required = true) int id) {
        ContatoEscolar contato = repEsc.findByid(id);
        ModelAndView model = new ModelAndView("contatoEscolar/contatoEscolar");
        model.addObject("contato", contato);

        return (model);
    }

    @RequestMapping(value = "/consultaFamiliar/{id}", method = RequestMethod.GET)
    public ModelAndView consultaFamiliar(@PathVariable("id") int id) {
        ContatoFamiliar contato = repFam.findByid(id);
        ModelAndView model = new ModelAndView("contatoFamiliar/contatoFamiliar");
        model.addObject("contato", contato);

        return (model);
    }

    @RequestMapping(value = "/removeContato/{id}", method = RequestMethod.GET)
    public String removeContato(@PathVariable("id") int id) {
        repCont.deleteById(id);

        return "redirect:/contatos";
    }

}