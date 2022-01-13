package com.rich.service.switches

import com.rich.client.dto.PokemonDTO
import com.rich.constant.ServiceConstant
import com.rich.converter.ObjectConverter
import com.rich.model.GetPokemonHeldItemsResponse
import com.rich.model.GetPropsResponse
import com.rich.service.SoapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("helmItemsPropServiceImpl")
class HelmItemsPropServiceImpl implements RequesSoapService {

    @Autowired SoapService service
    @Autowired ObjectConverter objectConverter

    @Override
    GetPropsResponse process(String name, String ip) {
        PokemonDTO dto = service.fetchProps(name, ip, ServiceConstant.METHOD_NAME_HELD_ITEMS)
        new GetPropsResponse(heldItems: new GetPokemonHeldItemsResponse(
                data: objectConverter.fromObject(dto.getHeldItems().toList())))
    }
}