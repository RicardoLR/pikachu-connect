package com.rich.service.switches

import com.rich.client.dto.PokemonDTO
import com.rich.constant.ServiceConstant
import com.rich.model.GetPokemonIdResponse
import com.rich.model.GetPropsResponse
import com.rich.service.SoapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("idPropServiceImpl")
class IdPropServiceImpl implements RequesSoapService {

    @Autowired SoapService service

    @Override
    GetPropsResponse process(String name, String ip) {
        PokemonDTO dto = service.fetchProps(name, ip, ServiceConstant.METHOD_NAME_ID)
        new GetPropsResponse(id: new GetPokemonIdResponse(
                data: dto.getId() as BigInteger))
    }
}