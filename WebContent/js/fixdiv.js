var d = (document.domain || "").match(/anjiehotel(travel)?\.com$/);
if (d) window.__uidc_init = new Date * 1;
var _ = window,
__ = document,
___ = __.documentElement,
anjiehotel = {
    module: {}
},
$topWin = _,
$$ = {};
_.module = {};
_.module.event = {}; (function() {
    try {
        for (;;) {
            var a = $topWin.parent;
            if (a && a != $topWin && a.anjiehotel) $topWin = a;
            else break
        }
    } catch(b) {}
})();
$$.browser = function(a) {
    var b = /opera/.test(a),
    h = /chrome/.test(a),
    c = /webkit/.test(a),
    l = !h && /safari/.test(a),
    f = !b && /msie/.test(a),
    e = f && /msie 7/.test(a),
    g = f && /msie 8/.test(a),
    i = f && /msie 9/.test(a),
    n = f && !e && !g && !i,
    m = !c && /gecko/.test(a),
    o = m && /rv:1\.8/.test(a);
    m && /rv:1\.9/.test(a);
    return {
        IE: f,
        IE6: n,
        IE7: e,
        IE8: g,
        IE9: i,
        Moz: m,
        FF2: o,
        Opera: b,
        Safari: l,
        WebKit: c,
        Chrome: h
    }
} (navigator.userAgent.toLowerCase());


$$.status = new
function() {
    this.load = this.domReady = !1;
    this.regEventCount = this.busy = 0;
    this.regEventHash = {};
    this.charset = (((_.__.charset ? _.__.charset: _.__.characterSet) || "").match(/^(gb2312|big5|utf-8)$/gi) || "gb2312").toString().toLowerCase();
    this.version = {
        gb2312: "zh-cn",
        "utf-8": "en"
    } [this.charset];
    this.alertDiv = _.__.getElementById("tuna_alert");
    this.container = _.__.getElementById("jsContainer");
    this.saveStatus = _.__.getElementById("jsSaveStatus");
    this.back = !1;
    this.pageValue = {
        data: {}
    };
    this.globalValue = {};
};
$$.module = {
    iframe: [],
    list: {},
    tab: {},
    selectAll: {},
    address: {
        source: {}
    },
    init: []
};
$$.string = {
    "zh-cn": {
        display: "@\u25b2|\u25bc@\u663e\u793a|\u9690\u85cf@"
    }
};
function $extend(a) {
    for (var b = 1; b < arguments.length; b++) {
        var h = arguments[b],
        c;
        for (c in h) h.hasOwnProperty(c) && (a[c] = h[c])
    }
    return a
}
_.$s2t = function(a) {
    return a
};
$$.status.domReady = !0;



$extend(Array.prototype, {
    each: function(a) {
        for (var b = 0, c = this.length; b < c; b++) if ((a ? a(this[b], b) : this[b]()) === !1) return ! 1;
        return ! 0
    }
});
$extend(String.prototype, {
    replaceWith: function(a) {
        return this.replace(/\{\$(\w+)\}/g,
        function(b, c) {
            return c in a ? a[c] : b
        })
    },
    trim: function() {
        return this.replace(/^\s+|\s+$/g, "")
    },
    toReString: function() {
        return this.replace(/([\.\\\/\+\*\?\[\]\{\}\(\)\^\$\|])/g, "\\$1")
    }
});



function $viewSize(a) {
    var a = a.ownerDocument || document,
    b = a.parentWindow || a.defaultView,
    c = a.documentElement;
    return {
        scrollLeft: b.pageXOffset || c.scrollLeft || a.body.scrollLeft || 0,
        scrollTop: b.pageYOffset || c.scrollTop || a.body.scrollTop || 0,
        clientTop: c.clientTop || 0,
        clientLeft: c.clientLeft || 0
    }
}
function $pageSize(a) {
    var b = {
        docWidth: ___.scrollWidth,
        docHeight: ___.scrollHeight,
        winWidth: ___.clientWidth,
        winHeight: ___.clientHeight,
        scrollLeft: $$.browser.WebKit ? __.body.scrollLeft: ___.scrollLeft,
        scrollTop: $$.browser.WebKit ? __.body.scrollTop: ___.scrollTop
    };
    if ($$.browser.WebKit) {
        var c = ___.$getStyle();
        b.docWidth += parseInt(c.marginLeft) + parseInt(c.marginRight);
        b.docHeight += parseInt(c.marginTop) + parseInt(c.marginBottom)
    }
    b.docWidth = Math.max(b.docWidth, b.winWidth);
    b.docHeight = Math.max(b.docHeight, b.winHeight);
    if (a) {
        var a = a == "win",
        d = $$.support.testIEZoom();
        b.left = a ? b.scrollLeft: 0;
        b.top = a ? b.scrollTop: 0;
        $$.browser.Moz && (c = ___.$getStyle(), b.left -= parseInt(c.borderLeftWidth) + parseInt(c.marginLeft), b.top -= parseInt(c.borderTopWidth) + parseInt(c.marginTop));
        b.width = a ? Math.round(b.winWidth / d) : Math.max(b.docWidth, b.winWidth);
        b.height = a ? Math.round(b.winHeight / d) : Math.max(b.docHeight, b.winHeight)
    }
    return b
}


function $fixE(a) {
    a = _.event || a;
    if (!a.target) a.target = a.srcElement || __;
    if (a.target.nodeType === 3) a.target = a.target.parentNode;
    if (!a.relatedTarget && a.fromElement) a.relatedTarget = a.fromElement === a.target ? a.toElement: a.fromElement;
    if (a.pageX == null && a.clientX != null) {
        var b = __.body;
        a.pageX = a.clientX + (___ && ___.scrollLeft || b && b.scrollLeft || 0) - (___ && ___.clientLeft || b && b.clientLeft || 0);
        a.pageY = a.clientY + (___ && ___.scrollTop || b && b.scrollTop || 0) - (___ && ___.clientTop || b && b.clientTop || 0)
    }
    a.$target = A$(a.target);
    return a
}
function $stopEvent(a, b) {
    a = $fixE(a);
    b = b || 0;
    if (b >= 0) a.preventDefault ? a.stopPropagation() : a.cancelBubble = !0;
    if (b != 0) a.preventDefault ? a.preventDefault() : a.returnValue = !1
}
function $getUid() {
    return "uid_" + (new Date).getTime() + Math.random().toString().substr(2, 5)
}
var $contains = __.compareDocumentPosition ?
function(a, b) {
    return a == b || !!(a.compareDocumentPosition(b) & 16)
}: function(a, b) {
    return a.contains ? a.contains(b) : !0
};
function $c(a) {
    return a.constructor == Array ? A$(__.createTextNode(a.join("\n"))) : A$(__.createElement(a))
}
var $createElement = $c;

function $pageValue() {
    return $pageValue.get.apply(_, arguments)
}
$pageValue.set = function(a, b) {
    $$.status.pageValue.data[a] = b;
    $$.browser.Opera && $savePageValue()
};
$pageValue.get = function(a) {
    var b = $$.status.pageValue.data;
    return b && a in b ? b[a] : null
};
$pageValue.del = function(a) {
    delete $$.status.pageValue.data[a];
    $$.browser.Opera && $savePageValue()
};
function $savePageValue() {
    $$.status.saveStatus.value = $toJson($$.status.pageValue)
}
function $globalValue() {}
function $getQuery(a) {
    return (a = (location.search || "").match(RegExp("[\\?&]" + a + "=([^&]+)", "i"))) ? unescape(a[1]) : null
}

function $parserRe(a) {
    var b = [],
    c = /\sid=['"]?([^\s>'"]+)/i,
    d = null,
    f = null;
    (a && a.innerHTML ? a: __.body).innerHTML.replace(/<[^>]+\smod=['"]?([\w|]+)[^>]+/g,
    function(g, p) {
        try {
            if (p.toLowerCase() !== "jmpinfo" && (d = g.match(c)) && (f = A$(d[1]))) p in anjiehotel.module ? new anjiehotel.module[p](f) : b.push(f)
        } catch(m) {
            $t("parserRe Error", [func, a])
        }
        return ""
    });
    var g = setInterval(function() {
        var a = b.shift();
        a ? $topWin.$d(a) : clearInterval(g)
    },
    50)
}
$$.module.queue = {};
function $d(a) { (A$(a).getAttribute("mod") || "").replace(/\w+/ig,
    function(b) {
        anjiehotel.module[b] ? new anjiehotel.module[b](a) : $isUndefined($$.module.queue[b]) ? $$.module.queue[b] = [a] : $$.module.queue[b].push(a)
    })
}
var $dealElement = $d;
function $t(a, b) {
    typeof console !== "undefined" && console.error(typeof a === "string" ? a: a.message, b)
}



function $fixElement(a) {
    function b(a, b, c) {
        "attachEvent" in a ? a.attachEvent("on" + b, c) : a.addEventListener(b, c)
    }
    function c(a) {
        for (var a = a.getElementsByTagName("input"), b = 0; b < a.length; b++) if (/checkbox|radio/.test(a[b].type)) return a[b];
        return null
    }
    a = a && a.nodeType ? a: _.__;
    if ($$.browser.IE6) {
        var d = a.getElementsByTagName("label");
        for (i = 0; i < d.length; i++) {
            var f = c(d[i]);
            f && /checkbox|radio/.test(f.type) &&
            function(a, c) {
                a._for = c;
                b(a, "mouseover",
                function() {
                    var b = a._for;
                    if (b) a.htmlFor = b.id || (b.id = $getUid()),
                    a._for = null;
                    b = a.style;
                    b.borderBottom = "#aaa 1px dashed";
                    b.paddingBottom = "0px";
                    b.color = "#1E1A75"
                });
                b(a, "mouseout",
                function() {
                    var b = a.style;
                    b.borderBottom = "";
                    b.paddingBottom = "";
                    b.color = ""
                })
            } (d[i], f)
        }
    }
    if ($$.browser.IE) {
        a = a.getElementsByTagName("select");
        for (i = 0; i < a.length; i++) a[i].onmousewheel = function() {
            return ! 1
        }
    }
}

var DOM = function() {
    function a(a) {
        return function(b) {
            for (var b = $fixE(b), c = a.module.event[b.type], d, f = 0; f < c.length; f++) if (c[f].enabled) try {
                if (d = c[f].func.call(a, b), d === !1) break
            } catch(h) {
                $t(h, [c[f].func, a])
            } else c.splice(f, 1),
            f--;
            return d
        }
    }
    function b() {
        var a = $pageSize("win");
        a.right = a.left + a.width;
        a.bottom = a.top + a.height;
        return a
    }
    function c(a, b) {
        for (var c = [], d = 0, f = a.length; d < f; d++) {
            var h;
            h = " " + b + " ";
            h = (" " + a[d].className + " ").replace(/[\n\t]/g, " ").indexOf(h) > -1 ? !0 : !1;
            h && (c[c.length] = a[d])
        }
        return c
    }
    function d(a, b, c) {
        if (!a) return null;
        b = b || "n";
        return b.match(RegExp({
            1 : "n",
            3 : "t",
            8 : "c"
        } [a.nodeType] || "o", "i")) ? a: c.call(a, b)
    }
    if (!this || this.nodeType === 3 || this.A$) return this;
    if (this != _) this.module = {},
    this.module.event = {};
    var f = /^[\.#]?[^\.#]+/;
    this.A$ = this.__ ?
    function(a, b) {
        if (typeof a == "object") return DOM.apply(a);
        var c;
        if (b) {
            var d = ___.innerHTML.match(RegExp("\\sid=([\\'\\\"]?)([\\w$]+?[_$]" + a.toReString() + ")\\1"), "g");
            if (d) for (var f = 0; f < d.length; f++) if (c = A$(d[f])) return c;
            return A$(a)
        } else c = __.getElementById(a);
        return c ? A$(c) : null
    }: function(a) {
        var b = this.getElementsByTagName(a);
        b.$each = function(a) {
            var c;
            if ($isUndefined(b.length)) a.call(this, b, 0);
            else for (var g = 0; g < b.length && (c = a.call(this, b[g], g)) !== !1; g++);
            return c === !1 ? 0 : 1
        };
        for (a = 0; a < b.length; a++) A$(b[a]);
        return b
    };
    if (this.nodeType == 1) {
        if (this.tagName == "INPUT" && /^(text|hidden)A$/i.test(this.type) || this.tagName == "TEXTAREA") this.isNull = function() {
            return ! this.value.trim()
        };
        if (/^SELECT$/.test(this.tagName)) this.$setValue = function(a) {
            for (var b = 0; b < this.options.length; b++) if (this.options[b].value == a) return this.selectedIndex = b,
            !0;
            return ! 1
        }
    }
    if (!this.hasAttribute) this.hasAttribute = function(a) {
        return ! $isUndefined(this.attributes[a])
    };
    this.$parentNode = function(a) {
        var b = A$(this.parentNode);
        a && b && b.tagName && b.tagName.toLowerCase() != a.toLowerCase() && (b = b.$parentNode(a));
        return b && b.tagName ? b: null
    };
    this.$firstChild = function() {
        return A$(this.firstChild)
    };
    this.$lastChild = function() {
        return A$(this.lastChild)
    };
    this.$childNodes = function() {
        for (var a = this.childNodes, b = 0; b < a.length; b++) A$(a[b]);
        return a
    };
    this.$nSib = this.$nextSibling = function() {
        return A$(this.nextSibling)
    };
    this.$pSib = this.$previousSibling = function() {
        return A$(this.previousSibling)
    };
    this.$click = function() {
        if (this.click) this.click();
        else {
            var a = __.createEvent("MouseEvents");
            a.initMouseEvent("click", !0, !0, _, 0, 0, 0, 0, 0, !1, !1, !1, !1, 0, this);
            this.dispatchEvent(a)
        }
    };
    this.$getStyle = function(a) {
        var b = this.currentStyle || _.getComputedStyle(this, null);
        return a ? b[a] : b
    };
    this.$getPara = function() {
        var a, b = (a = this.getAttribute(arguments[0]) || "").split(a.indexOf("\u000c") > -1 ? "\u000c": "|");
        for (a = 0; a < Math.max(arguments.length - 1, b.length); a++) b[a] = b[a] || arguments[a + 1] || "";
        return b
    };
    this.$r = this.$regEvent = function(b, c, d, f) {
        f = f || 50;
        arguments.length == 3 && typeof d == "number" && (f = d, d = null);
        var n = this;
        b.constructor != Array && (b = [b]);
        c.constructor != Array && (c = [c]);
        b.each(function(b) {
            c.each(function(c) {
                b = b.replace(/^(on)?/i, "");
                b = b == "DOMContentLoaded" ? "domready": b.toLowerCase();
                b == "domready" && (n = _);
                var g = {
                    enabled: !0,
                    obj: n,
                    event: b,
                    func: c,
                    hash: d,
                    level: f,
                    id: _.$$.status.regEventCount++
                };
                b == "domready" && $$.status.domReady || b == "load" && (n == _ || n == __.body) && $$.status.load ? c() : (b in n.module.event || (n.module.event[b] = [], n.attachEvent ? n.attachEvent("on" + b, a(n)) : n.addEventListener(b, a(n), !1)), n.module.event[b].push(g), n.module.event[b].sort(function(a, b) {
                    return a.level - b.level || a.id - b.id
                }));
                d && (d in $$.status.regEventHash || ($$.status.regEventHash[d] = []), $$.status.regEventHash[d].push(g))
            })
        })
    };
    

    this.$getWin = function() {
        var a = this.ownerDocument,
        a = a.parentWindow || a.defaultView;
        return a == window && a !== window ? window: a
    };
    this.$getEl = function(a) {
        a || (a = "");
        var b = arguments[1],
        d = f.exec(a);
        if (!d) {
            if (!b) return null;
            for (var m = [], n = 0, h = b.length; n < h; n++) m[m.length] = A$(b[n]);
            return m.length ? m: null
        }
        var h = d[0],
        n = h.substring(1),
        d = a.replace(h, ""),
        q = h.substring(0, 1),
        r = this;
        if (b) if (q === ".") m = c(b, n);
        else {
            q = A$(n);
            n = 0;
            for (h = b.length; n < h; n++) b[n] === q && (m = [q])
        } else if (r = r.nodeName ? r: __, q === ".") {
            b = r.getElementsByTagName("*");
            if (!b) return null;
            m = c(b, n)
        } else m = q === "#" ? (q = A$(n)) ? [q] : null: r.getElementsByTagName(h);
        if (!m || !m.length) return null;
        return arguments.callee(d, m)
    };
    this.$g = this.$selNode = function(a) {
        function b(a, c) {
            var d = [],
            g = a.match(/^([\.\#]*)([a-zA-Z0-9\-_*]+)(.*)$/i),
            f;
            if (!g) return [];
            if (g[1] == "#")(f = A$(g[2])) && d.push(f);
            else if (g[1] == ".") c.each(function(a) {
                a.A$("*").$each(function(a) {
                    RegExp("\\b" + g[2] + "\\b").test(a.className) && d.push(A$(a))
                })
            });
            else for (var v = 0; v < c.length; v++) if (f = c[v].A$(g[2])) for (var w = 0; w < f.length; w++) d.push(f[w]);
            g[3].replace(/\[([^!=]+)(=|!=)([^\]]*)\]/gi,
            function(a, b, c, g) {
                a = d.slice(0);
                d = [];
                a.each(function(a) {
                    b = {
                        "class": "className",
                        "for": "htmlFor"
                    } [b] || b;
                    var h = a[b] || a.getAttribute(b),
                    h = b == "className" ? RegExp("\\b" + g + "\\b").test(h) : h == g;
                    c == "=" == h && d.push(A$(a))
                })
            });
            return d
        }
        var c = [this == _ ? _.__.body: this],
        d = [],
        f = [];
        a.replace(/[^\[,]([^\[,]*(\[[^\]]*\])*)+/g,
        function(a) {
            var g = c.slice(0);
            a.replace(/(#|\*)/gi, " $1").replace(/([^\^ ])\.(\w+)/gi, "$1[className=$2]").trim().split(/\s+/g).each(function(a) {
                g = b(a, g)
            });
            d = d.concat(g)
        });
        d.each(function(a) {
            if (!a.__selNodeFlag__) a.__selNodeFlag__ = !0,
            f.push(a)
        });
        f.each(function(a) {
            a.__selNodeFlag__ = !1;
            a.hasAttribute("__selNodeFlag__") && a.removeAttribute("__selNodeFlag__")
        });
        return f.length == 0 ? null: f
    };
    this.$getPos = function() {
        var a = this.$getWin();
        if (a == $topWin) return $offset(this);
        for (var b = $offsetWin(this), c = []; a != $topWin;) {
            if (a.parent != $topWin) c = $offsetWin(a.frameElement);
            else {
                var c = A$(a.frameElement),
                d = c.ownerDocument,
                d = d.defaultView ? d.defaultView.getComputedStyle(c, null) : c.currentStyle,
                f = {
                    thin: 2,
                    medium: 4,
                    thick: 6
                },
                c = $offset(c);
                if (!/^none|hidden$/i.test(d.borderLeftStyle)) {
                    var h = d.borderLeftWidth;
                    c[0] += f[h] || parseFloat(h) || 0
                }
                if (!/^none|hidden$/i.test(d.borderTopStyle)) h = d.borderTopWidth,
                c[1] += f[h] || parseFloat(h) || 0;
                $$.browser.IE || (c[0] += parseFloat(d.paddingLeft), c[1] += parseFloat(d.paddingTop))
            }
            b[0] += c[0];
            b[1] += c[1];
            a = a.parent
        }
        return b
    };
    this.$setPos = function(a, c, d) {
        function f(b, v) {
            function q(a, b, c, d) {
                return c + {
                    l: 0,
                    c: b.offsetWidth / 2,
                    r: b.offsetWidth,
                    t: 0,
                    m: b.offsetHeight / 2,
                    b: b.offsetHeight
                } [a || "l"] * d
            }
            return q(c.match(b), this, q(d.match(b), a, h[v], 1), -1) + "px"
        }
        var n = !1,
        h = a.$getPos();
        c === "auto" ? (c = "lt", d = "lb", n = !0) : (c || (c = "lt"), d || (d = "lb"));
        if (n) {
            var n = b(),
            q = {
                x: a.offsetWidth,
                y: a.offsetHeight
            },
            r = {
                x: this.offsetWidth,
                y: this.offsetHeight
            },
            s = (c + d).split("");
            h[0] + r.x > n.right && h[0] + q.x - r.x >= n.left && (s[0] = "r", s[2] = "r");
            h[1] + q.y + r.y > n.bottom && h[1] - r.y >= n.top && (s[1] = "b", s[3] = "t");
            c = s.slice(0, -2).join("");
            d = s.slice(2).join("")
        }
        this.style.left = f.call(this, /[lcr]/i, 0);
        this.style.top = f.call(this, /[tmb]/i, 1)
    };
    this.$setIframe = function(a) {
        if (a === !0 || $$.browser.IE6) {
            if (this.module.iframe) a = this.module.iframe;
            else {
                a = function() {
                    for (var a = 0; a < $topWin.$$.module.iframe.length; a++) if ($topWin.$$.module.iframe[a].$getStyle("display") == "none") return $topWin.$$.module.iframe[a]
                } ();
                if (!a) {
                    a = $topWin.$c("iframe");
                    with(a.style) width = height = "0px",
                    background = "#FFF",
                    position = "absolute",
                    display = "none",
                    zIndex = 100;
                    a.frameBorder = 0;
                    a.id = a.name = $getUid();
                    $topWin.$$.status.container.appendChild(a);
                    $topWin.$$.module.iframe.push(a);
                    with($topWin.frames[a.id].document) open(),
                    write("<style>html,body{overflow:hidden}</style>"),
                    close()
                }
                this.module.iframe = a
            }
            a.$setPos(this, "tl", "tl");
            with(a.style) width = this.offsetWidth + "px",
            height = this.offsetHeight + "px",
            display = "";
            return a
        }
    };
    this.$clearIframe = function() {
        var a = this.module.iframe;
        if (a) a.style.display = "none",
        this.module.iframe = null;
        return a
    };
    this.$focusNext = function() {
        if (this.form) {
            try {
                this.blur()
            } catch(a) {}
            for (var b = this.form.elements, c, d = 0; d < b.length; d++) {
                if (c && !A$(b[d]).disabled && b[d].$isDisplay()) try {
                    b[d].focus();
                    break
                } catch(f) {}
                b[d] == this && (c = !0)
            }
        }
    };
    return this
};
DOM.apply(_);
DOM.apply(__);
DOM.apply(___);
DOM.apply($$.status.alertDiv);
$$.support = {
    
    testIEZoom: function() {
        if (!$$.browser.IE7) return 1;
        var a = $$.support.zoomTester;
        if (!a) {
            var a = __.body,
            a = $$.status.container || a,
            b = __.createElement("div");
            b.style.cssText = "position:absolute;left:-10000px;top:-10000px;width:400px;height:100px;";
            a.appendChild(b);
            a = this.zoomTester = b
        }
        a = a.getBoundingClientRect();
        return (a.right - a.left) / 100 || 1
    },
    zoomTester: null
};


var $offsetWin, $offset;
"getBoundingClientRect" in ___ ? ($offsetWin = function(a) {
    var b = [0, 0],
    c = a.ownerDocument,
    d = $$.support.testIEZoom();
    c && $contains(c.documentElement, a) && (a = a.getBoundingClientRect(), b[0] = Math.round(a.left / d), b[1] = Math.round(a.top / d));
    return b
},
$offset = function(a) {
    if (!a) return null;
    var b = [0, 0],
    c = $viewSize(a),
    a = $offsetWin(a),
    d = $$.support.testIEZoom();
    b[1] = a[1] + Math.round((c.scrollTop - c.clientTop) / d);
    b[0] = a[0] + Math.round((c.scrollLeft - c.clientLeft) / d);
    return b
}) : ($offset = function(a) {
    if (!a) return null;
    $$.support.testCss();
    var b = a.ownerDocument,
    c = b.documentElement,
    d = [a.offsetLeft, a.offsetTop],
    f = a.offsetParent,
    g;
    g = b.defaultView ? b.defaultView.getComputedStyle(a, null) : a.currentStyle;
    for (var j = $$.support, p = /^t(?:able|d|h)A$/i;
    (a = a.parentNode) && a !== b.body && a !== c;) {
        if (j.supportsFixedPosition && g.position === "fixed") break;
        g = b.defaultView ? b.defaultView.getComputedStyle(a, null) : a.currentStyle;
        d[0] -= a.scrollLeft;
        d[1] -= a.scrollTop;
        if (a === f) {
            d[0] += a.offsetLeft;
            d[1] += a.offsetTop;
            if (j.doesNotAddBorder && (!j.doesAddBorderForTableAndCells || !p.test(a.nodeName))) d[1] += parseFloat(g.borderTopWidth) || 0,
            d[0] += parseFloat(g.borderLeftWidth) || 0;
            f = a.offsetParent
        }
        j.subtractsBorderForOverflowNotVisible && g.overflow !== "visible" && (d[1] += parseFloat(g.borderTopWidth) || 0, d[0] += parseFloat(g.borderLeftWidth) || 0)
    }
    if (g.position === "relative" || g.position === "static") d[1] += b.body.offsetTop,
    d[0] += b.body.offsetLeft;
    return d
},
$offsetWin = function(a) {
    var b = [0, 0],
    c = $viewSize(a),
    a = $offset(a);
    b[1] = a[1] - c.scrollTop + c.clientTop;
    b[0] = a[0] - c.scrollLeft + c.clientLeft;
    return b
});

var c_allyes_text = {},
c_allyes_delay = 1E3;

anjiehotel.module.notice = function(a) {
    var b;
    a.module.notice = new
    function() {
        this.enabled = !0;
        this.tip = a.getAttribute("mod_notice_tip") || "";
        this.check = function() {
            if (a.module.notice.enabled) with(a) isNull() ? (style.color = "gray", value = module.notice.tip) : style.color = ""
        };
        this.isNull = a.isNull = function() {
            return a.value.trim() == "" || a.value == a.module.notice.tip
        }
    };
    a.$r("focus",
    function() {
        b = !0;
        if (a.module.notice.enabled && (a.style.color = "", a.value == a.module.notice.tip)) a.value = ""
    },
    10);
    a.$r("blur",
    function() {
        b = !1;
        a.module.notice.check()
    },
    90);
    a.module.notice.check()
};

_.$r("domReady",
function() {
    var a = ".tuna_calendar{width:362px;font-size:12px;font-family:tahoma, Arial, Helvetica, simsun, sans-serif;position:absolute;z-index:1000;background-color:#fff;border:solid 1px #999;-moz-box-shadow:3px 4px 5px #ccc;-webkit-box-shadow:3px 4px 5px #ccc;box-shadow:3px 4px 5px #ccc;margin:0;padding:5px 6px 4px}.tuna_calendar dt,.tuna_calendar dd{margin:0;padding:0}.tuna_calendar dl,.tuna_calendar dt,.tuna_calendar dd { margin:0; padding:0; }.tuna_calendar .select_day,.tuna_calendar dd a:hover,.tuna_calendar .calendar_title01 a,.tuna_calendar .calendar_title02 a,.tuna_calendar .today{background:#FFF url({$picserver}/common/un_bg_calender110117.png) no-repeat}.tuna_calendar a{color:#005ead;font-weight:bold;text-decoration:none!important}.tuna_calendar dl{float:left;width:175px;padding:6px 0 0}.tuna_calendar #calendar_month2{position:absolute;top:28px;left:186px;z-index:2;padding-bottom:5px;padding-left:6px;border-left:2px solid #999}.tuna_calendar dt{float:left;width:25px;height:22px;background:#ececec;font-weight:normal;color:#666;font-size:12px;line-height:20px;text-align:center;cursor:default}.tuna_calendar .day0,.tuna_calendar .day6{color:#f90;font-weight:bold}.tuna_calendar .day6{width:24px}.tuna_calendar dd{clear:both;padding-top:1px;display:inline-block}.tuna_calendar dd a{font-size:11px;text-align:center;height:24px;width:22px;line-height:24px;float:left;outline-width:0;background-color:#fff;padding:0 2px 1px 1px}.tuna_calendar dd a:hover{background-color:#fff;background-position:-26px -48px}.tuna_calendar .today{font-weight:bold;background-position:0 -74px;}.tuna_calendar .today:hover{}.tuna_calendar .select_day,.tuna_calendar .select_day:hover{color:#fff;background-color:#629be0;background-position:0 -48px}.tuna_calendar .blank_day,.tuna_calendar .over_day{color:#dbdbdb;font-weight:normal;cursor:default}.tuna_calendar .blank_day:hover,.tuna_calendar .over_day:hover{background-color:#fff;background-image:none}.tuna_calendar div{float:left;width:181px;color:#fff;font-weight:bold;height:23px;background:#004fb8}.tuna_calendar div a{cursor:pointer;width:40px;line-height:20px}.tuna_calendar .calendar_title01 span,.tuna_calendar .calendar_title02 span{float:left;width:143px;text-align:center;line-height:23px}.tuna_calendar .calendar_title01 span{padding-right:14px}.tuna_calendar .calendar_title02 span{padding-left:14px}.tuna_calendar .calendar_title01 a,.tuna_calendar .calendar_title02 a{background-color:#2d7fdd;float:left;width:23px;height:23px;overflow:hidden;text-indent:-10em}.tuna_calendar .calendar_title01 a{float:left}.tuna_calendar .calendar_title02 a{background-position:right 0;float:right}.tuna_calendar .calendar_title01 a:hover{background-color:#4895ec;background-position:0 -24px}.tuna_calendar .calendar_title02 a:hover{background-color:#4895ec;background-position:right -24px}.tuna_calendar b,.tuna_calendar i{background-color:#fff;display:block;width:372px;height:1px;border-right:1px solid #c3c3c3;border-left:1px solid #c3c3c3;overflow:hidden;position:absolute;left:0;z-index:1}.tuna_calendar i{border-top:1px solid #999;top:-2px}.tuna_calendar b{border-bottom:1px solid #999;bottom:-2px;_bottom:-3px}address_hot li,.address_hot_abb,.address_hot_adress{list-style:none;margin:0;padding:0}.address_hot_adress a{text-decoration:none}#tuna_address{font-family: Arial,Simsun; font-size: 12px;}#tuna_address #address_warp{background: none repeat scroll 0 0 #FFFFFF; border: 1px solid #7F9DB9; margin: 0; min-height: 305px; padding: 0 0 4px; text-align: left; width: 220px;}* html #tuna_address #address_warp{height: 305px;}#tuna_address #address_message{background-color: #67A1E2; border: medium none; color: #FFFFFF; display: block; font-family: Simyou; height: 1.7em; line-height: 20px; overflow: hidden; padding: 2px 0 2px 9px; width: auto; word-wrap: break-word;}#tuna_address #address_list{margin: 0; min-height: 277px; padding: 0;}* html #tuna_address #address_list{height: 277px;}#tuna_address #address_list span{float: right; font: 10px/22px verdana; margin: 0; overflow: hidden; padding: 0; text-align: right; white-space: nowrap; width: 110px;}#tuna_address #address_list a{border-bottom: 1px solid #FFFFFF; border-top: 1px solid #FFFFFF; color: #0055AA; cursor: pointer; display: block; height: 22px; line-height: 22px; min-height: 22px; overflow: hidden; padding: 1px 9px 0; text-align: left; text-decoration: none;}* html #tuna_address #address_list a{height: 22px;}#tuna_address #address_list a:hover{background: none repeat scroll 0 0 #E8F4FF; border-bottom: 1px solid #7F9DB9; border-top: 1px solid #7F9DB9;}#tuna_address .address_selected{background: none repeat scroll 0 0 #FFE6A6; color: #FFFFFF; height: 22px;}#tuna_address .address_pagebreak{display: none; line-height: 25px; margin: 0; padding: 0; text-align: center;}#tuna_address .address_pagebreak a{color: #0055AA; display: inline-block; font-family: Arial,Simsun,sans-serif; font-size: 14px; margin: 0; padding: 0 4px; text-align: center; text-decoration: underline; width: 15px;}#tuna_address #address_arrowl, #tuna_address #address_arrowr{color: #0055AA;}#tuna_address a.address_current{color: #000000; text-decoration: none;}.address_hot{background-color: #FFFFFF; font-size: 12px; width: 550px;}.address_hotcity{background-color: #67A1E2; border-color: #2C7ECF; border-style: solid; border-width: 1px 1px 0; color: #CEE3FC; height: 24px; line-height: 24px; padding-left: 10px;}.address_hotcity strong{color: #FFFFFF;}.address_hotlist{border-color: #999999; border-style: solid; border-width: 0 1px 1px; overflow: hidden; padding: 5px;}.address_hot_abb{border-bottom: 1px solid #5DA9E2; padding-bottom: 20px;}.address_hot_abb li{color: #005DAA; cursor: pointer; float: left; height: 20px; line-height: 20px; list-style-type: none; text-align: center;}.address_hot_abb li span{padding:0 8px;}.address_hot_abb li .hot_selected{display:block; padding:0 7px; background-color: #FFFFFF; border-color: #5DA9E2; border-style: solid; border-width: 1px 1px 0; color: #000000; font-weight: bold;}.address_hot_adress{padding-top: 4px; width: 100%;}.address_hot_adress li{float: left; height: 24px; overflow: hidden; width: 67px;}.address_hot_adress li a{border: 1px solid #FFFFFF; color: #000000; display: block; height: 22px; line-height: 22px; padding-left: 5px;}.address_hot_adress li a:hover{background-color: #E8F4FF; border: 1px solid #ACCCEF; text-decoration: none;}.span_fest{text-indent:-9999px} .yuan_dan span, .chu_xi span, .chun_jie span, .yuan_xiao span, .qing_ming span, .lao_dong span, .duan_wu span, .zhong_qiu span, .guo_qing span { display:block; height:24px; background-image:url({$picserver}/common/icon_festival.png); background-repeat:no-repeat; } .tuna_calendar .yuan_dan:hover, .tuna_calendar .chu_xi:hover, .tuna_calendar .chun_jie:hover, .tuna_calendar .yuan_xiao:hover, .tuna_calendar .qing_ming:hover, .tuna_calendar .lao_dong:hover, .tuna_calendar .duan_wu:hover, .tuna_calendar .zhong_qiu:hover, .tuna_calendar .guo_qing:hover { background-image:url({$picserver}/common/icon_festival.png); background-repeat:no-repeat; background-position:0 -400px; cursor:pointer; } .tuna_calendar .festival_select, .tuna_calendar .festival_select:hover { background-image:url({$picserver}/common/icon_festival.png); background-repeat:no-repeat; background-position:0 -360px; } .yuan_dan span { background-position:0 6px; } .chu_xi span { background-position:0 -35px; } .chun_jie span { background-position:0 -74px; } .yuan_xiao span { background-position:0 -114px; } .qing_ming span { background-position:0 -155px; } .lao_dong span { background-position:0 -194px; } .duan_wu span { background-position:0 -234px; } .zhong_qiu span { background-position:0 -274px; } .guo_qing span { background-position:0 -314px; }".replaceWith({
        picserver: ""
    }),
    b;
    $$.browser.IE ? (b = document.createStyleSheet(), b.cssText = a) : (b = document.createElement("style"), b.type = "text/css", b.textContent = a, document.getElementsByTagName("head")[0].appendChild(b))
});
$$.string.address = {
		b: "\u8f93\u5165\u4e2d\u6587/\u62fc\u97f3\u6216\u2191\u2193\u9009\u62e9.",
        i: "\u8f93\u5165",
        j: "\u6216\u2191\u2193\u9009\u62e9.",
        k: "\u4e2d\u6587/\u62fc\u97f3",
        e: "\u8bf7\u8f93\u5165\u81f3\u5c11\u4e24\u4e2a\u5b57\u6bcd\u6216\u4e00\u4e2a\u6c49\u5b57.",
        h: "",
        o: "\u6309\u62fc\u97f3\u6392\u5e8f",
        s: "\u5bf9\u4e0d\u8d77, \u627e\u4e0d\u5230: ",
        l: "\u7ed3\u679c\u5171",
        p: "\u9879,\u2190\u2192\u7ffb\u9875",
        a: ",\u5171"
};


(function() {
    function a(a, b) {
        return RegExp("\\b" + b + "\\b").test(a.className)
    }
    function b(a, b) {
        var c = a.match(/^[^\|]+/),
        d = b.match(/^[^\|]+/);
        return c > d ? 1 : c == d ? 0 : -1
    }
    function c() {
        var a = $c("div");
        a.style.width = "0px";
        a.style.height = "0px";
        a.innerHTML = '<div id="tuna_address" style="display:none;position:absolute;top:0;z-index:120;overflow:hidden;-moz-box-shadow:2px 2px 5px #333;-webkit-box-shadow:2px 2px 5px #333;"><div id="address_warp"><div id="address_message">&nbsp;</div><div id="address_list"><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a><a class="a1" href="###"><span>&nbsp;</span>&nbsp;</a></div><div class="address_pagebreak" id="address_p"><a id="address_arrowl" href="javascript:;" name="p">&lt;-</a><a id="address_p1" href="javascript:;" name="1" class="address_current">1</a><a id="address_p2" href="javascript:;" name="2">2</a><a id="address_p3" href="javascript:;" name="3">3</a><a id="address_p4" href="javascript:;" name="4">4</a><a id="address_p5" href="javascript:;" name="5">5</a><a id="address_arrowr" href="javascript:;" name="n">-&gt;</a></div></div></div>';
        A$("jsContainer").appendChild(a);
        g = A$("tuna_address");
        $$.module.address.source["default"] = "@@";
        j = A$("address_warp");
        p = A$("address_message");
        m = A$("address_list");
        n = [A$("address_p"), A$("address_p1"), A$("address_p2"), A$("address_p3"), A$("address_p4"), A$("address_p5")];
        h = A$("address_arrowl");
        q = A$("address_arrowr");
        r = m.getElementsByTagName("a");
        for (a = 0; a < r.length; a++) r[a].cloneNode(!0)
    }
    var d = "_".toString() + "hotData",
    f = {
        target: null,
        hotTarget: null,
        data: null,
        selectedValue: null,
        hotSelected: "\u70ed\u95e8",
        tabTagName: "span",
        tabListTagName: "ol",
        cityListTagName: "ul",
        cityTagName: "span",
        hotData: {"热门": "@80|北京@",'A': "@36|安庆@112|安顺@150|安阳@245|鞍山"},
        hotTemplate: {
            container: '<div class="address_hot" style="display:none;top:0;-moz-box-shadow:2px 2px 5px #333;-webkit-box-shadow:2px 2px 5px #333;" id="address_hot">{$text}</div>',
            title: '<div class="address_hotcity"><strong>\u70ed\u95e8\u57ce\u5e02</strong>{$text}</div>',
            hotlist: '<div class="address_hotlist">{$text}</div>',
            tags: '<ol class="address_hot_abb" style="{$style}">{$text}</ol>',
            tag: "<li><span {$className}>{$text}</span></li>",
            items: '<ul class="address_hot_adress layoutfix" {$display} type="{$type}">{$text}</ul>',
            item: '<li><a href="###" data="{$data}">{$text}</a></li>'
        },
        hotClassNames: {
            tagSelected: "hot_selected"
        }
    },
    g,
    j,
    p,
    m,
    n,
    h,
    q,
    r,
    s = 0;

	
    anjiehotel.module.address = function(k) {
        function v() {
            B && B.releaseCapture && (B.releaseCapture(), B = null)
        }
        function w() { (f.hotTarget || g).$setPos(k)
        }
        function R() {
            var a = [],
            b;

			

            for (b in f.hotData) s++,
            a.push(f.hotTemplate.tag.replaceWith({
                text: b,
                className: _.$s2t(k.hotSelected) == b ? "class=" + f.hotClassNames.tagSelected: ""
            }));
            return a.join("")
        }
        function S() {
            var a = [],
            b;
            for (b in f.hotData) {
                var c = [],
                c = f.hotData[b].replace(/@([^@]*)\|([^@]*)/g,
                function(a, b, c) {
                    return f.hotTemplate.item.replaceWith({
                        data: [b, c].join("|"),
                        text: c
                    })
                });
                a.push(f.hotTemplate.items.replaceWith({
                    text: c,
                    display: $s2t(k.hotSelected) == $s2t(b) ? "": "style='display:none'",
                    type: b
                }))
            }
            return a.join("")
        }
        function N() {
            for (var a = u.getElementsByTagName(f.cityListTagName), b = 0; b < a.length; b++) if (a[b].style.display == "") return a[b];
            return null
        }
        function T(a, b) {
            clearInterval(E);
            var c = b.$target.getAttribute("data");
            if (!c) return ! 1;
            c = c.split("|");
            focusTarget.value = c[1].trim();
            var d = focusTarget.getAttribute("mod_address_reference");
            if (d && A$(d)) A$(d).value = c[0].trim(),
            o.hook.change && o.hook.change(A$(k));
            u.$clearIframe();
            u.style.display = "none";
            k.blur();
            setTimeout(function() {
                o.focusNext && setTimeout(function() {
                    k.$focusNext()
                },
                1)
            },
            0);
            return ! 0
        }
        function U() {
            u.onmousedown = function(b) {
                var b = $fixE(b),
                c = b.$target;
                c.setCapture && (v(), c.setCapture(), B = c);
                f.olObj = c.$parentNode(f.tabListTagName);
                f.ulObj = c.$parentNode(f.cityListTagName);
                if (f.olObj) {
                    var b = f.olObj,
                    d = N();
                    if (b && d) {
                        N().style.display = "none";
                        k.hotSelected = c.innerText || c.textContent;
                        a: {
                            for (var d = _.$s2t(k.hotSelected), g = u.getElementsByTagName(f.cityListTagName), w = 0; w < g.length; w++) if (g[w].getAttribute("type") == d) {
                                d = g[w];
                                break a
                            }
                            d = null
                        }
                        d.style.display = "";
                        a: {
                            b = b.getElementsByTagName(f.cityTagName);
                            for (d = 0; d < b.length; d++) if (a(b[d], f.hotClassNames.tagSelected)) {
                                b = b[d];
                                break a
                            }
                            b = null
                        }
                        d = f.hotClassNames.tagSelected;
                        if (a(b, d)) d = RegExp("(\\s|^)" + d.toReString() + "(\\s|$)"),
                        b.className = b.className.replace(d, " ").split(" ").join(" ");
                        c = c.tagName == f.cityTagName.toUpperCase() ? c: c.getElementsByTagName(f.cityTagName)[0];
                        b = f.hotClassNames.tagSelected;
                        if (!a(c, b)) c.className = c.className + " " + b
                    }
                } else if (f.ulObj) return T(f.ulObj, b);
                else focusTarget.select();
                return ! 1
            };
            u.onmouseup = v
        }
        function V() {
            f.hotData = $$.module.address.source[o.source + d];
            if (f.hotData) {
                O = k;
                k.select();
                if (!k.hotSelected) k.hotSelected = f.hotSelected;
                var a = A$("address_hot");
                a && a.parentNode.removeChild(a);
                var a = f.hotTemplate.container.replaceWith({
                    text: [f.hotTemplate.title.replaceWith({
                        text: $$.module.address.source[o.source + "_keyWord"] || " \uff08\u53ef\u76f4\u63a5\u8f93\u5165\u57ce\u5e02\u6216\u57ce\u5e02\u62fc\u97f3\uff09"
                    }), f.hotTemplate.hotlist.replaceWith({
                        text: [f.hotTemplate.tags.replaceWith({
                            text: R(),
                            style: s > 1 ? "": "display:none;"
                        }), S()].join("")
                    })].join("")
                }),
                b = "",
                a = a.replace(/\{guestId:(\w+)\}/g,
                function(a, c) {
                    b = c; ! k.guests[b] && A$(b) && (k.guests[b] = A$(b));
                    return '<div class="hot_guest" id="{id}"></div>'.replace("{id}", c + x)
                }),
                c = $c("div");
                c.innerHTML = a;
                u = A$(c.removeChild(c.firstChild));
                __.body.appendChild(u);
                for (b in k.guests) a = A$(b + x),
                a.parentNode.className = "",
                a.parentNode.replaceChild(k.guests[b], a);
                u.style.display = "";
                u.style.zIndex = 111;
                u.style.position = "absolute";
                u.$setPos(O);
                u.$setIframe();
                U();
                s = 0
            }
        }
        function H(a) {
            a && $stopEvent(a);
            switch (this) {
            case h:
                y.m_get(y.page - 1);
                break;
            case q:
                y.m_get(y.page + 1);
                break;
            default:
                y.m_get(parseInt(this.firstChild.nodeValue))
            }
            return ! 1
        }
        function K() {
            with(g.style) width = j.offsetWidth + "px",
            height = j.offsetHeight + "px";
            g.$setIframe()
        }
        function P() {
            if (o.suggest.length == 0) {
                if (g.style.display = "none", t !== null) r[t].className = "",
                t = null
            } else y.m_set(o.suggest),
            p.lastChild.nodeValue = $$.status.version.match(/^zh-/) ? $$.string.address.i + (k.module.notice ? k.module.notice.tip: $$.string.address.k) + $$.string.address.j: $$.string.address.b
        }
        function L() {
            focusTarget = k;
            var a = k.value.trim();
            if (a !== I) if (I = a, a = a.replace(/([\(\)\\\[\]\.\+\?\*\|\^\$])/gi, "\\$1").replace(/@|\|/gi, ""), C && $$.module.address.source[o.source + d]) V(),
            C = !1,
            f.hotTarget = u;
            else {
                if (u && !u.style.display) f.hotTarget = null,
                u.$clearIframe(),
                u.style.display = "none";
                if (a) {
                    if (u) u.$clearIframe(),
                    u.style.display = "none";
                    g.style.display = "";
                    var c = $$.module.address.source[o.source],
                    v = RegExp("@([^@]*\\|)?" + a + "[^@]*", "gi"),
                    w = RegExp("@[^@]*" + a + "[^@]*", "gi"),
                    h = [],
                    n = [],
                    j = [],
                    c = c.replace(RegExp("@([^\\|@]*\\|)?" + a + "[^@]*", "gi"),
                    function(a) {
                        h.push(a);
                        return ""
                    });
                    h && h.sort(b);
                    c = c.replace(v,
                    function(a) {
                        n.push(a);
                        return ""
                    });
                    n && n.sort(b);
                    c = c.replace(w,
                    function(a) {
                        j.push(a);
                        return ""
                    });
                    j && j.sort(b);
                    arr = h.concat(n).concat(j);
                    p.style.backgroundColor = arr.length ? "#67A1E2": "#0053AA";
                    if (!arr || !arr.length) {
                        p.lastChild.nodeValue = o.auto ? $$.string.address.s + ($$.status.version == "en" ? "": k.value) : $$.string.address.h + k.value + ", " + $$.string.address.o;
                        if (!o.auto && (g.style.display = "none", t !== null)) r[t].className = "",
                        t = null;
                        m.style.display == "none" && P();
                        K()
                    } else p.lastChild.nodeValue = $$.string.address.h + k.value + ", " + $$.string.address.o,
                    y.m_set(arr);
                    C = !1
                } else P(),
                K()
            }
        }
        function J(a, b) {
            k.value = D[a][1] || D[a][0];
            if (o.reference) o.reference.value = D[a][2];
            if (z) z.value = D.join("|");
            o.hook.change && o.hook.change(k);
            r[t].className = "";
            t = null;
            b !== !1 && o.focusNext && setTimeout(function() {
                k.$focusNext()
            },
            1)
        }
        var B = null;
        k.guests = {};
        var x = (new Date).getTime(),
        O,
        u,
        F,
        G = k.$getWin(),
        o = k.module.address = {},
        E,
        t = null,
        I,
        D = [],
        C = !1;
        o.ver = k.getAttribute("mod_address_ver");
        o.autoFilter = /^(true|1)A$/.test(k.getAttribute("mod_address_autofilter"));
        g || c();
        k.setAttribute("autoComplete", "off");
        $r("beforeunload",
        function() {
            k.setAttribute("autoComplete", "on")
        });
        o.focusNext = k.getAttribute("mod_address_focusNext");
        o.focusNext = /^(1|true)A$/i.test(o.focusNext || "");
        o.reference = k.getAttribute("mod_address_reference");
        var z = k.getAttribute("mod_address_cookie");
        if (z && (z = G.A$(z), !z)) {
            var A = G.$c("input");
            with(A) type = "hidden",
            id = name = z;
            z = A;
            k.parentNode.insertBefore(z, k)
        }
        if (o.reference) o.reference = G.A$(o.reference) || G.A$(o.reference, !0);
        var A = k.getAttribute("mod_address_suggest"),
        Q = k.getAttribute("mod_address_cookieSuggest");
        o.suggest = [];
        if (Q) o.suggest = Q.match(/[^@]+@/gi),
        A && o.suggest._push(A.match(/[^@]+@/gi));
        else if (A) o.suggest = A.match(/[^@]+@/gi);
        if (o.suggest.length > 12) o.suggest = o.suggest.slice(0, 12);
        o.source = k.getAttribute("mod_address_source") || "default";
        
        o.auto = k.getAttribute("mod_address_auto");
        o.auto = o.auto && o.auto.match(/^(false|0)A$/i) ? !1 : !0;
        o.redraw = function() {
            E && L()
        };
        o.hook = {};
        (k.getAttribute("mod_address_hook") || "").replace(/(on)?([^;:]+):([^;]+)/gi,
        function(a, b, c, d) {
            o.hook[c.toLowerCase()] = G[d]
        });
        var M = !1,
        y = new
        function() {
            var a;
            this.maxpage = this.page = 1;
            this.m_get = function(b) {
                if (!a || !b || b < 1 || b > this.maxpage) return null;
                this.page = b;
                this.pagelist = a.slice((b - 1) * 12, Math.min(b * 12, a.length));
                for (b = 0; b < r.length; b++) if (b < this.pagelist.length) {
                    r[b].style.display = "block";
                    var c = this.pagelist[b].replace(/@/g, "").split("|");
                    r[b].lastChild.nodeValue = c[1];
                    r[b].firstChild.firstChild.nodeValue = c[0];
                    D[b] = c
                } else r[b].style.display = "none",
                D[b] = null;
                if (t !== null) {
                    if (t >= this.pagelist.length) r[t].className = "",
                    t = this.pagelist.length - 1,
                    r[t].className = "address_selected"
                } else t = 0,
                r[0].className = "address_selected";
                var b = this.maxpage < 6 || this.page < 3 ? 1 : this.page > this.maxpage - 2 ? this.maxpage - 4 : this.page - 2,
                c = Math.min(b + 4, this.maxpage),
                d;
                h.style.display = this.page == 1 ? "none": "";
                q.style.display = this.page == this.maxpage ? "none": "";
                for (var f = b; f < b + 5; f++) d = n[f - b + 1],
                f <= c ? (d.firstChild.nodeValue = f, d.className = f == this.page ? "address_current": "", d.style.display = "") : d.style.display = "none";
                n[0].style.display = this.maxpage > 1 ? "block": "none";
                m.style.display = p.style.display = "";
                if (!F) g.style.display = "",
                b = k.$getPos(),
                g.offsetWidth + b[0] > ___.offsetWidth ? g.$setPos(k, "tr", "br") : g.$setPos(k),
                g.$setIframe(),
                F = !0;
                K.call(this)
            };
            this.m_set = function(b) {
                a = b;
                this.maxpage = Math.ceil(b.length / 12);
                this.page = 1;
                this.m_get(1)
            }
        };
        

        k.$r("onfocus",
        function() {
            function a(b) {
                r[b].onmousedown = function() {
                    J(b);
                    k.blur()
                }
            }
            if (!M) {
                M = !0;
                setTimeout(function() {
                    M = !1
                });
                C = !0;
                F = !1;
                m.style.display = p.style.display = n[0].style.display = "none";
                g.onmousedown = function(a) {
                    C = !1;
                    var a = $fixE(a),
                    b = a.$target;
                    b.setCapture && (v(), b.setCapture(), B = b);
                    $stopEvent(a, 1);
                    return ! 1
                };
                g.onmouseup = v;
                _.$r("resize", w);
                for (var b = 0; b < r.length; b++) new a(b);
                h.onmousedown = q.onmousedown = H;
                for (b = 1; b < n.length; b++) n[b].onmousedown = H;
                I = null;
                if (t !== null) r[t].className = "address_selected";
                o.hook.focus && o.hook.focus(k);
                L();
                E = setInterval(L, 150)
            }
        });
        k.blur();
        k.$r("onblur",
        function() {
            C = !1;
            clearInterval(E);
            E = null;
            if (u) u.$clearIframe(),
            u.style.display = "none";
            g.$clearIframe();
            g.style.display = "none";
            if (t !== null) k.value && (o.auto ? J(t, !1) : o.check()),
            r[t].className = "",
            t = null;
            g.onmousedown = null;
            g.onmouseup = null;
            v();
            _.$ur("resize", w)
        });
        o.hook.load && o.hook.load(k)
    }
})();



(function() {
    $r("domready", [$parserRe, $fixElement,function() {}]);
})();