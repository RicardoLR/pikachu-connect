package com.rich.service.switches

import com.rich.constant.ServiceConstant
import com.rich.exception.NoValidPropException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class SwitchServiceImpl implements SwitchService {

    @Autowired
    protected ApplicationContext context

    private RequesSoapService getPropBeanService(String prop) {
        switch (prop) {
            case ServiceConstant.METHOD_NAME_ALL:
                context.getBean(AllPropServiceImpl)
                break
            case ServiceConstant.METHOD_NAME_ABILITIES:
                context.getBean(AbilitiesPropServiceImpl)
                break
            case ServiceConstant.METHOD_NAME_BASE_EXPERIENCE:
                context.getBean(ExperiencePropServiceImpl)
                break
            case ServiceConstant.METHOD_NAME_ID:
                context.getBean(IdPropServiceImpl)
                break
            case ServiceConstant.METHOD_NAME_HELD_ITEMS:
                context.getBean(HelmItemsPropServiceImpl)
                break
            case ServiceConstant.METHOD_NAME_LOCATION_AREA_ENCOUNTERS:
                context.getBean(LocationAreaPropServiceImpl)
                break
            default:
                throw new NoValidPropException()
                break
        }
    }

    @Override
    Object process(String name, String prop, String ip) {
        this.getPropBeanService(prop).process(name, ip)
    }

}
