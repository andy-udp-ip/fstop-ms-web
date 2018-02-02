
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

package tw.com.fstop.app.spring.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import tw.com.fstop.common.ValidateException;

/**
 * 客製化的 exception handler.
 * Handler function 的 exception parameter 類型必需與 annotation 所指定的 exception 類型相同，
 * 或是 annotation 所指定的 exception 的父類別.
 *
 * @since 1.0.1
 */
@Slf4j
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = { ValidateException.class })
    protected ResponseEntity<Object> handleValidationException(ValidateException ex, WebRequest request)
    {  
        String bodyOfResponse = "Validation Error";
        if (ex.getMessage() != null && !ex.getMessage().trim().isEmpty())
        {
            bodyOfResponse = ex.getMessage();
        }
        log.debug("validate exception=" + bodyOfResponse);        
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
