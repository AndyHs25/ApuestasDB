package com.Idat.AppApuestas.Controllers;

import com.Idat.AppApuestas.DTO.OddDTO;
import com.Idat.AppApuestas.Models.odd;
import com.Idat.AppApuestas.Services.OddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/odd")
public class OddController {

    @Autowired
    private OddService oddService;

    @GetMapping
    public List<odd> getAllOdd(){
        return oddService.getAllOdds();
    }

    @PostMapping
    public odd addOdd(@RequestBody OddDTO oddDTO){
        return oddService.addOdd(oddDTO);
    }

    @GetMapping("/{id}")
    public Optional<odd> getOddById(@PathVariable Long id){
        return oddService.buscarOddId(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<odd> updateOdd(@PathVariable Long id, @RequestBody OddDTO oddDTO){
        odd Odd = oddService.updateOdd(id,oddDTO);
        if(Odd != null){
            return ResponseEntity.ok(Odd);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteOdd(@PathVariable Long id){
        oddService.deleteOddById(id);
    }


}
