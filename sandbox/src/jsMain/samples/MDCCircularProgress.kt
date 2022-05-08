package samples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.petuska.kmdc.checkbox.MDCCheckbox
import dev.petuska.kmdc.circular.progress.MDCCircularProgress
import dev.petuska.kmdc.form.field.MDCFormField
import dev.petuska.kmdc.slider.MDCSlider
import dev.petuska.kmdc.slider.onInput
import dev.petuska.kmdc.typography.MDCOverline
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.dom.Div

object MDCCircularProgress : Samples() {
  override val content: SamplesRender = {
    Sample("Interactive", "Play around with various settings live") {
      var determinate by remember { mutableStateOf(false) }
      var closed by remember { mutableStateOf(false) }
      var fourColor by remember { mutableStateOf(true) }
      var progress by remember { mutableStateOf(0.5) }
      var size by remember { mutableStateOf(36) }
      Div {
        MDCFormField {
          MDCCheckbox(determinate, label = "Determinate", attrs = {
            onClick { determinate = !determinate }
          })
        }
        MDCFormField {
          MDCCheckbox(closed, label = "Closed", attrs = {
            onClick { closed = !closed }
          })
        }
        MDCFormField {
          MDCCheckbox(fourColor, label = "Four Colour", attrs = {
            onClick { fourColor = !fourColor }
          })
        }
        Div {
          MDCOverline("Size")
          MDCSlider(opts = {
            label = "Size"
            discrete = true
            value = size
            min = 24
            max = 48
          }, attrs = {
            onInput {
              size = it.detail.value.toInt()
            }
          })
        }
        Div {
          MDCOverline("Progress")
          MDCSlider(opts = {
            label = "Progress"
            disabled = !determinate
            discrete = true
            value = progress
            min = 0
            max = 1
            step = 0.01
          }, attrs = {
            onInput {
              progress = it.detail.value.toDouble()
            }
          })
        }
      }
      Div(attrs = {
        style {
          display(DisplayStyle.Flex)
          flexDirection(FlexDirection.Row)
          justifyContent(JustifyContent.SpaceAround)
        }
      }) {
        repeat(5) {
          MDCCircularProgress({
            this.determinate = determinate
            this.closed = closed
            this.label = "Custom Circular Progress $it"
            this.progress = progress
            this.size = size
            this.fourColor = fourColor
          })
        }
      }
    }
  }
}