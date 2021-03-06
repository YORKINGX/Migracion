package com.bod.config.constants;

import com.bod.constants.ServiciosDaoBaseBean;
import com.bod.facade.ParametrosFacade;
import com.bod.util.LogNBL;
import com.bod.util.logger.Log;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

@Named("serviciosDaoConfig")
@Stateless(name="maserviciosDaoConfigNbl")
public class ServiciosDaoConfig
  extends ServiciosDaoBaseBean
  implements Serializable
{
  Map<String, String> configParameter = new HashMap();
  @EJB
  private ParametrosFacade parametrosFacade;
  
  public Map<String, String> init()
  {
    try
    {
      this.configParameter.put(DIR_CODE_SERVICE_WSDL_WSPMTONLINE, this.parametrosFacade.porCodigo(DIR_CODE_SERVICE_WSDL_WSPMTONLINE));
      this.configParameter.put(DIR_CODE_SERVICE_WSDL_WSPMTOFFLINE, this.parametrosFacade.porCodigo(DIR_CODE_SERVICE_WSDL_WSPMTOFFLINE));
      this.configParameter.put(DIR_CODE_SERVICE_WSDL_WSAFFILIATIONONLINE, this.parametrosFacade.porCodigo(DIR_CODE_SERVICE_WSDL_WSAFFILIATIONONLINE));
      this.configParameter.put(DIR_CODE_SERVICE_WSDL_WSAFFILIATION, this.parametrosFacade.porCodigo(DIR_CODE_SERVICE_WSDL_WSAFFILIATION));
      this.configParameter.put(AUTH_SSL_WS, this.parametrosFacade.porCodigo(AUTH_SSL_WS));
      this.configParameter.put(DIR_CODE_PARAM_BANKID, this.parametrosFacade.porCodigo(DIR_CODE_PARAM_BANKID));
      this.configParameter.put(DIR_CODE_PARAM_CHANNELCODE, this.parametrosFacade.porCodigo(DIR_CODE_PARAM_CHANNELCODE));
      this.configParameter.put(USER_WS, this.parametrosFacade.porCodigo(USER_WS));
      this.configParameter.put(PASS_WS, this.parametrosFacade.porCodigo(PASS_WS));
    }
    catch (Exception e)
    {
      Log.getInstance().warn(LogNBL.MIGRAR.getCodigo(), "NBL", "Advertencia init", e);
    }
    return this.configParameter;
  }
}
