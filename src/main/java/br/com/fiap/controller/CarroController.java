package br.com.fiap.controller;
import br.com.fiap.entity.Carro;
import br.com.fiap.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public String listCarros(Model model) {
        model.addAttribute("carro", carroService.findAll());
        return "carros/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("carro", new Carro());
        return "carros/form";
    }

    @PostMapping
    public String saveCarro(@ModelAttribute Carro carro) {
        carroService.save(carro);
        return "redirect:carros";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Carro carro = carroService.findById(id).orElseThrow(() -> new IllegalArgumentException("Carro não encontrado Id: " + id));
        model.addAttribute("carro", carro);
        return "carros/editForm";
    }

    @PostMapping("/update/{id}")
    public String updateCarro(@PathVariable Long id, @ModelAttribute Carro carro) {
        carro.setId(id); // Defina o ID do carro para garantir que você está atualizando o carro correto.
        carroService.save(carro);
        return "redirect:/carros";
    }


    @GetMapping("/delete/{id}")
    public String deleteCarro(@PathVariable Long id) {
        carroService.deleteById(id);
        return "redirect:/carros";
    }
}
