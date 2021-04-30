package lesson7.articletask.controller;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.entity.Lavozim;
import lesson7.articletask.payload.LavozimDto;
import lesson7.articletask.payload.UserDto;
import lesson7.articletask.service.LavozimService;
import lesson7.articletask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lavozim")
public class LavozimController {
    @Autowired
    LavozimService lavozimService;
    @PreAuthorize(value = "hasAuthority('ADD_LAVOZIM')")
    @PostMapping
    public HttpEntity<?> addLavozim(@Valid @RequestBody LavozimDto lavozimDto){
        ApiResponse apiResponse = lavozimService.addLavozim(lavozimDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:401).body(apiResponse);
    }
    @PreAuthorize(value = "hasAuthority('EDIT_LAVOZIM')")
    @PutMapping("/{id}")
    public HttpEntity<?> editLavozim(@PathVariable Long id, @Valid @RequestBody LavozimDto lavozimDto){
        ApiResponse apiResponse =lavozimService.editLavozim(id,lavozimDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:401).body(apiResponse);
    }
    @PreAuthorize(value = "hasAuthority('DELETE_LAVOZIM')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteLavozim(@PathVariable Long id){
        ApiResponse apiResponse = lavozimService.deleteLavozim(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:401).body(apiResponse);
    }
    @PreAuthorize(value = "hasAuthority('VIEW_LAVOZIM')")
    @GetMapping
    public List<Lavozim> getLavozimList(){
        return lavozimService.getLavozimList();
    }

}
