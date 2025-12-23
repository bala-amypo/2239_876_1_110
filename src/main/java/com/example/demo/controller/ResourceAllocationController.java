package com.example.demo.controller;

import com.example.demo.service.ResourceAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allocations")
public class ResourceAllocationController {

    @Autowired
    private ResourceAllocationService allocationService;

    @PostMapping("/allocate/{requestId}")
    public void autoAllocate(@PathVariable Long requestId) {
        allocationService.autoAllocate(requestId);
    }
}
