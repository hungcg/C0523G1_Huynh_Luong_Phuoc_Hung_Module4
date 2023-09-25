package com.example.music.controller;

import com.example.music.model.Song;
import com.example.music.model.SongDto;
import com.example.music.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService service;

    @GetMapping("")
    public String showList(Model model) {
        List<Song> songList = service.showAll();
        model.addAttribute("songList", songList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            service.create(song);
            redirectAttributes.addFlashAttribute("message", "create success");
            return "redirect:/";
        }
    }

    @GetMapping("/showEdit")
    public String showEdit(@RequestParam int id, Model model) {
        Song song = service.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("editSong",songDto);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("editSong") SongDto songDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            Song song = new Song();
            service.update(song);
            redirectAttributes.addFlashAttribute("message", "edit success");
            return "redirect:/";
        }
    }
}
