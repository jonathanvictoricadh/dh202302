package com.dh.g.wallet.client;

import com.dh.g.wallet.config.LoadBalancerConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Optional;

@FeignClient(name="api-customer")
@LoadBalancerClient(value="api-customer", configuration= LoadBalancerConfiguration.class)
public interface CustomerClient {

    @GetMapping("/customer/{doctype}/{docnum}")
    Optional<CustomerDTO> getCustomer (@PathVariable String doctype, @PathVariable String docnum);

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class CustomerDTO {
        private Long id;
        private String name;
        private String surname;
        private String gender;
        private LocalDate birthDate;

    }

}
