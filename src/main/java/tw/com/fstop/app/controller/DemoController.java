
/*
 * Copyright (c) 2017, FSTOP, Inc. All Rights Reserved.
 *
 * You may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tw.com.fstop.app.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import tw.com.fstop.app.model.User;
import tw.com.fstop.app.service.UserService;
import tw.com.fstop.common.ValidateException;

@Slf4j
@Controller
public class DemoController
{
    // private static final Logger log =
    // LoggerFactory.getLogger(DemoController.class);

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getUser(@RequestParam("id") String id, Map<String, Object> model) throws ValidateException
    {
        log.debug("demo={}", id);

        //User user = userService.getUserById(id);
        User user = new User();

        model.put("time", new Date());
        model.put("message", "demo demo");
        model.put("user", user);
        return "demo";
    }

    // @RequestMapping(method = RequestMethod.GET, value = "/", produces ="text/plain")
    // headers = {"content-type=application/x-www-form-urlencoded" })
    // consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = { MediaType.TEXT_PLAIN_VALUE })
    @ResponseBody
    public String demo(Model model) throws ValidateException
    {
        log.debug("demo");
        return "OK";
    }

}
