package dev.petuska.kmdc.fab

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.ContentBuilder
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.applyAttrs
import dev.petuska.kmdc.core.applyContent
import dev.petuska.kmdc.core.classes
import dev.petuska.kmdc.ripple.MDCRipple
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLSpanElement

@JsModule("@material/fab/mdc-fab.scss")
private external val MDCFabStyles: dynamic

public enum class MDCFabType(public vararg val classes: String) {
  Regular, Mini("mdc-fab--mini"), Extended("mdc-fab--extended")
}

public interface MDCFabScope : ElementScope<HTMLButtonElement>

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-fab)
 */
@MDCDsl
@Composable
public fun MDCFab(
  type: MDCFabType = MDCFabType.Regular,
  exited: Boolean = false,
  touch: Boolean = false,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCFabScope>? = null
) {
  MDCFabStyles
  Button(
    attrs = {
      classes("mdc-fab")
      classes(type.classes)
      if (touch) classes("mdc-fab--touch")
      if (exited) classes("mdc-fab--exited")
      applyAttrs(attrs)
    }
  ) {
    Div(attrs = { classes("mdc-fab__ripple") })
    MDCRipple()
    applyContent(content)
    if (touch) Div(attrs = { classes("mdc-fab__touch") })
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-fab)
 */
@MDCDsl
@Composable
public fun MDCFabScope.Icon(
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-fab__icon")
      applyAttrs(attrs)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-fab)
 */
@MDCDsl
@Composable
public fun MDCFabScope.Label(
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-fab__label")
      applyAttrs(attrs)
    },
    content = content
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-fab)
 */
@MDCDsl
@Composable
public fun MDCFabScope.Label(
  text: String,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
) {
  Label(
    attrs = attrs,
    content = { Text(text) }
  )
}