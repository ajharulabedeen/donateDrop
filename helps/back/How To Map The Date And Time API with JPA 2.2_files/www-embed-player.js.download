(function(){/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
var m;function aa(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}}
function p(a){var b="undefined"!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];return b?b.call(a):{next:aa(a)}}
function ba(a){for(var b,c=[];!(b=a.next()).done;)c.push(b.value);return c}
var ca="function"==typeof Object.create?Object.create:function(a){function b(){}
b.prototype=a;return new b},da="function"==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){if(a==Array.prototype||a==Object.prototype)return a;
a[b]=c.value;return a};
function ea(a){a=["object"==typeof globalThis&&globalThis,a,"object"==typeof window&&window,"object"==typeof self&&self,"object"==typeof global&&global];for(var b=0;b<a.length;++b){var c=a[b];if(c&&c.Math==Math)return c}throw Error("Cannot find global object");}
var fa=ea(this);function q(a,b){if(b){for(var c=fa,d=a.split("."),e=0;e<d.length-1;e++){var f=d[e];f in c||(c[f]={});c=c[f]}d=d[d.length-1];e=c[d];f=b(e);f!=e&&null!=f&&da(c,d,{configurable:!0,writable:!0,value:f})}}
var ia;if("function"==typeof Object.setPrototypeOf)ia=Object.setPrototypeOf;else{var ja;a:{var ka={a:!0},la={};try{la.__proto__=ka;ja=la.a;break a}catch(a){}ja=!1}ia=ja?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+" is not extensible");return a}:null}var ma=ia;
function u(a,b){a.prototype=ca(b.prototype);a.prototype.constructor=a;if(ma)ma(a,b);else for(var c in b)if("prototype"!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c];a.L=b.prototype}
function na(a,b,c){if(null==a)throw new TypeError("The 'this' value for String.prototype."+c+" must not be null or undefined");if(b instanceof RegExp)throw new TypeError("First argument to String.prototype."+c+" must not be a regular expression");return a+""}
q("String.prototype.endsWith",function(a){return a?a:function(b,c){var d=na(this,b,"endsWith");b+="";void 0===c&&(c=d.length);for(var e=Math.max(0,Math.min(c|0,d.length)),f=b.length;0<f&&0<e;)if(d[--e]!=b[--f])return!1;return 0>=f}});
q("String.prototype.startsWith",function(a){return a?a:function(b,c){var d=na(this,b,"startsWith");b+="";for(var e=d.length,f=b.length,g=Math.max(0,Math.min(c|0,d.length)),h=0;h<f&&g<e;)if(d[g++]!=b[h++])return!1;return h>=f}});
q("Symbol",function(a){function b(e){if(this instanceof b)throw new TypeError("Symbol is not a constructor");return new c("jscomp_symbol_"+(e||"")+"_"+d++,e)}
function c(e,f){this.f=e;da(this,"description",{configurable:!0,writable:!0,value:f})}
if(a)return a;c.prototype.toString=function(){return this.f};
var d=0;return b});
q("Symbol.iterator",function(a){if(a)return a;a=Symbol("Symbol.iterator");for(var b="Array Int8Array Uint8Array Uint8ClampedArray Int16Array Uint16Array Int32Array Uint32Array Float32Array Float64Array".split(" "),c=0;c<b.length;c++){var d=fa[b[c]];"function"===typeof d&&"function"!=typeof d.prototype[a]&&da(d.prototype,a,{configurable:!0,writable:!0,value:function(){return oa(aa(this))}})}return a});
function oa(a){a={next:a};a[Symbol.iterator]=function(){return this};
return a}
function v(a,b){return Object.prototype.hasOwnProperty.call(a,b)}
var pa="function"==typeof Object.assign?Object.assign:function(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(d)for(var e in d)v(d,e)&&(a[e]=d[e])}return a};
q("Object.assign",function(a){return a||pa});
q("WeakMap",function(a){function b(k){this.f=(h+=Math.random()+1).toString();if(k){k=p(k);for(var l;!(l=k.next()).done;)l=l.value,this.set(l[0],l[1])}}
function c(){}
function d(k){var l=typeof k;return"object"===l&&null!==k||"function"===l}
function e(k){if(!v(k,g)){var l=new c;da(k,g,{value:l})}}
function f(k){var l=Object[k];l&&(Object[k]=function(n){if(n instanceof c)return n;e(n);return l(n)})}
if(function(){if(!a||!Object.seal)return!1;try{var k=Object.seal({}),l=Object.seal({}),n=new a([[k,2],[l,3]]);if(2!=n.get(k)||3!=n.get(l))return!1;n["delete"](k);n.set(l,4);return!n.has(k)&&4==n.get(l)}catch(r){return!1}}())return a;
var g="$jscomp_hidden_"+Math.random();f("freeze");f("preventExtensions");f("seal");var h=0;b.prototype.set=function(k,l){if(!d(k))throw Error("Invalid WeakMap key");e(k);if(!v(k,g))throw Error("WeakMap key fail: "+k);k[g][this.f]=l;return this};
b.prototype.get=function(k){return d(k)&&v(k,g)?k[g][this.f]:void 0};
b.prototype.has=function(k){return d(k)&&v(k,g)&&v(k[g],this.f)};
b.prototype["delete"]=function(k){return d(k)&&v(k,g)&&v(k[g],this.f)?delete k[g][this.f]:!1};
return b});
q("Map",function(a){function b(){var h={};return h.previous=h.next=h.head=h}
function c(h,k){var l=h.f;return oa(function(){if(l){for(;l.head!=h.f;)l=l.previous;for(;l.next!=l.head;)return l=l.next,{done:!1,value:k(l)};l=null}return{done:!0,value:void 0}})}
function d(h,k){var l=k&&typeof k;"object"==l||"function"==l?f.has(k)?l=f.get(k):(l=""+ ++g,f.set(k,l)):l="p_"+k;var n=h.g[l];if(n&&v(h.g,l))for(var r=0;r<n.length;r++){var w=n[r];if(k!==k&&w.key!==w.key||k===w.key)return{id:l,list:n,index:r,u:w}}return{id:l,list:n,index:-1,u:void 0}}
function e(h){this.g={};this.f=b();this.size=0;if(h){h=p(h);for(var k;!(k=h.next()).done;)k=k.value,this.set(k[0],k[1])}}
if(function(){if(!a||"function"!=typeof a||!a.prototype.entries||"function"!=typeof Object.seal)return!1;try{var h=Object.seal({x:4}),k=new a(p([[h,"s"]]));if("s"!=k.get(h)||1!=k.size||k.get({x:4})||k.set({x:4},"t")!=k||2!=k.size)return!1;var l=k.entries(),n=l.next();if(n.done||n.value[0]!=h||"s"!=n.value[1])return!1;n=l.next();return n.done||4!=n.value[0].x||"t"!=n.value[1]||!l.next().done?!1:!0}catch(r){return!1}}())return a;
var f=new WeakMap;e.prototype.set=function(h,k){h=0===h?0:h;var l=d(this,h);l.list||(l.list=this.g[l.id]=[]);l.u?l.u.value=k:(l.u={next:this.f,previous:this.f.previous,head:this.f,key:h,value:k},l.list.push(l.u),this.f.previous.next=l.u,this.f.previous=l.u,this.size++);return this};
e.prototype["delete"]=function(h){h=d(this,h);return h.u&&h.list?(h.list.splice(h.index,1),h.list.length||delete this.g[h.id],h.u.previous.next=h.u.next,h.u.next.previous=h.u.previous,h.u.head=null,this.size--,!0):!1};
e.prototype.clear=function(){this.g={};this.f=this.f.previous=b();this.size=0};
e.prototype.has=function(h){return!!d(this,h).u};
e.prototype.get=function(h){return(h=d(this,h).u)&&h.value};
e.prototype.entries=function(){return c(this,function(h){return[h.key,h.value]})};
e.prototype.keys=function(){return c(this,function(h){return h.key})};
e.prototype.values=function(){return c(this,function(h){return h.value})};
e.prototype.forEach=function(h,k){for(var l=this.entries(),n;!(n=l.next()).done;)n=n.value,h.call(k,n[1],n[0],this)};
e.prototype[Symbol.iterator]=e.prototype.entries;var g=0;return e});
q("Object.entries",function(a){return a?a:function(b){var c=[],d;for(d in b)v(b,d)&&c.push([d,b[d]]);return c}});
q("String.prototype.includes",function(a){return a?a:function(b,c){return-1!==na(this,b,"includes").indexOf(b,c||0)}});
q("Set",function(a){function b(c){this.f=new Map;if(c){c=p(c);for(var d;!(d=c.next()).done;)this.add(d.value)}this.size=this.f.size}
if(function(){if(!a||"function"!=typeof a||!a.prototype.entries||"function"!=typeof Object.seal)return!1;try{var c=Object.seal({x:4}),d=new a(p([c]));if(!d.has(c)||1!=d.size||d.add(c)!=d||1!=d.size||d.add({x:4})!=d||2!=d.size)return!1;var e=d.entries(),f=e.next();if(f.done||f.value[0]!=c||f.value[1]!=c)return!1;f=e.next();return f.done||f.value[0]==c||4!=f.value[0].x||f.value[1]!=f.value[0]?!1:e.next().done}catch(g){return!1}}())return a;
b.prototype.add=function(c){c=0===c?0:c;this.f.set(c,c);this.size=this.f.size;return this};
b.prototype["delete"]=function(c){c=this.f["delete"](c);this.size=this.f.size;return c};
b.prototype.clear=function(){this.f.clear();this.size=0};
b.prototype.has=function(c){return this.f.has(c)};
b.prototype.entries=function(){return this.f.entries()};
b.prototype.values=function(){return this.f.values()};
b.prototype.keys=b.prototype.values;b.prototype[Symbol.iterator]=b.prototype.values;b.prototype.forEach=function(c,d){var e=this;this.f.forEach(function(f){return c.call(d,f,f,e)})};
return b});
var qa=function(){function a(){function c(){}
new c;Reflect.construct(c,[],function(){});
return new c instanceof c}
if("undefined"!=typeof Reflect&&Reflect.construct){if(a())return Reflect.construct;var b=Reflect.construct;return function(c,d,e){c=b(c,d);e&&Reflect.setPrototypeOf(c,e.prototype);return c}}return function(c,d,e){void 0===e&&(e=c);
e=ca(e.prototype||Object.prototype);return Function.prototype.apply.call(c,e,d)||e}}();
q("Reflect.construct",function(){return qa});
var x=this||self;function y(a,b,c){a=a.split(".");c=c||x;a[0]in c||"undefined"==typeof c.execScript||c.execScript("var "+a[0]);for(var d;a.length&&(d=a.shift());)a.length||void 0===b?c[d]&&c[d]!==Object.prototype[d]?c=c[d]:c=c[d]={}:c[d]=b}
var ra=/^[\w+/_-]+[=]{0,2}$/,sa=null;function ta(a){return(a=a.querySelector&&a.querySelector("script[nonce]"))&&(a=a.nonce||a.getAttribute("nonce"))&&ra.test(a)?a:""}
function z(a,b){for(var c=a.split("."),d=b||x,e=0;e<c.length;e++)if(d=d[c[e]],null==d)return null;return d}
function ua(){}
function va(a){a.ha=void 0;a.getInstance=function(){return a.ha?a.ha:a.ha=new a}}
function wa(a){var b=typeof a;if("object"==b)if(a){if(a instanceof Array)return"array";if(a instanceof Object)return b;var c=Object.prototype.toString.call(a);if("[object Window]"==c)return"object";if("[object Array]"==c||"number"==typeof a.length&&"undefined"!=typeof a.splice&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("splice"))return"array";if("[object Function]"==c||"undefined"!=typeof a.call&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("call"))return"function"}else return"null";
else if("function"==b&&"undefined"==typeof a.call)return"object";return b}
function xa(a){var b=wa(a);return"array"==b||"object"==b&&"number"==typeof a.length}
function A(a){return"function"==wa(a)}
function ya(a){var b=typeof a;return"object"==b&&null!=a||"function"==b}
function za(a){return Object.prototype.hasOwnProperty.call(a,Aa)&&a[Aa]||(a[Aa]=++Ba)}
var Aa="closure_uid_"+(1E9*Math.random()>>>0),Ba=0;function Ca(a,b,c){return a.call.apply(a.bind,arguments)}
function Da(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var e=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(e,d);return a.apply(b,e)}}return function(){return a.apply(b,arguments)}}
function B(a,b,c){Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?B=Ca:B=Da;return B.apply(null,arguments)}
function Ea(a,b){var c=Array.prototype.slice.call(arguments,1);return function(){var d=c.slice();d.push.apply(d,arguments);return a.apply(this,d)}}
var C=Date.now||function(){return+new Date};
function D(a,b){y(a,b,void 0)}
function E(a,b){function c(){}
c.prototype=b.prototype;a.L=b.prototype;a.prototype=new c;a.prototype.constructor=a}
;function Fa(a,b){if(!a||/[?&]dsh=1(&|$)/.test(a))return null;if(/[?&]ae=1(&|$)/.test(a)){var c=/[?&]adurl=([^&]+)/.exec(a);if(!c)return null;var d=b?c.index:a.length;try{return{wa:a.slice(0,d)+"&act=1"+a.slice(d),ya:decodeURIComponent(c[1])}}catch(f){return null}}if(/[?&]ae=2(&|$)/.test(a)){c=a;d="";if(b){var e=a.indexOf("&adurl=");0<e&&(c=a.slice(0,e),d=a.slice(e))}return{wa:c+"&act=1"+d,ya:c+"&dct=1"+d}}return null}
;function G(a){if(Error.captureStackTrace)Error.captureStackTrace(this,G);else{var b=Error().stack;b&&(this.stack=b)}a&&(this.message=String(a))}
E(G,Error);G.prototype.name="CustomError";function Ga(a){var b=a.url,c=a.ub;this.j=!!a.ab;this.g=Fa(b,c);a=/[?&]dsh=1(&|$)/.test(b);this.h=!a&&/[?&]ae=1(&|$)/.test(b);this.i=!a&&/[?&]ae=2(&|$)/.test(b);this.f=/[?&]adurl=([^&]*)/.exec(b)}
;var Ia=Array.prototype.indexOf?function(a,b){return Array.prototype.indexOf.call(a,b,void 0)}:function(a,b){if("string"===typeof a)return"string"!==typeof b||1!=b.length?-1:a.indexOf(b,0);
for(var c=0;c<a.length;c++)if(c in a&&a[c]===b)return c;return-1},H=Array.prototype.forEach?function(a,b,c){Array.prototype.forEach.call(a,b,c)}:function(a,b,c){for(var d=a.length,e="string"===typeof a?a.split(""):a,f=0;f<d;f++)f in e&&b.call(c,e[f],f,a)},Ja=Array.prototype.filter?function(a,b){return Array.prototype.filter.call(a,b,void 0)}:function(a,b){for(var c=a.length,d=[],e=0,f="string"===typeof a?a.split(""):a,g=0;g<c;g++)if(g in f){var h=f[g];
b.call(void 0,h,g,a)&&(d[e++]=h)}return d},Ka=Array.prototype.map?function(a,b){return Array.prototype.map.call(a,b,void 0)}:function(a,b){for(var c=a.length,d=Array(c),e="string"===typeof a?a.split(""):a,f=0;f<c;f++)f in e&&(d[f]=b.call(void 0,e[f],f,a));
return d},La=Array.prototype.reduce?function(a,b,c){return Array.prototype.reduce.call(a,b,c)}:function(a,b,c){var d=c;
H(a,function(e,f){d=b.call(void 0,d,e,f,a)});
return d};
function Ma(a,b){a:{var c=a.length;for(var d="string"===typeof a?a.split(""):a,e=0;e<c;e++)if(e in d&&b.call(void 0,d[e],e,a)){c=e;break a}c=-1}return 0>c?null:"string"===typeof a?a.charAt(c):a[c]}
function Na(a,b){var c=Ia(a,b);0<=c&&Array.prototype.splice.call(a,c,1)}
function Oa(a){var b=a.length;if(0<b){for(var c=Array(b),d=0;d<b;d++)c[d]=a[d];return c}return[]}
function Pa(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(xa(d)){var e=a.length||0,f=d.length||0;a.length=e+f;for(var g=0;g<f;g++)a[e+g]=d[g]}else a.push(d)}}
;function Qa(a){var b=!1,c;return function(){b||(c=a(),b=!0);return c}}
;function Ra(a,b){for(var c in a)b.call(void 0,a[c],c,a)}
function Sa(a,b){var c=xa(b),d=c?b:arguments;for(c=c?0:1;c<d.length;c++){if(null==a)return;a=a[d[c]]}return a}
function Ta(a){var b=Ua,c;for(c in b)if(a.call(void 0,b[c],c,b))return c}
function Va(a){for(var b in a)return!1;return!0}
function Wa(a,b){if(null!==a&&b in a)throw Error('The object already contains the key "'+b+'"');a[b]=!0}
function Xa(a,b){for(var c in a)if(!(c in b)||a[c]!==b[c])return!1;for(var d in b)if(!(d in a))return!1;return!0}
function Ya(a){var b={},c;for(c in a)b[c]=a[c];return b}
function Za(a){var b=wa(a);if("object"==b||"array"==b){if(A(a.clone))return a.clone();b="array"==b?[]:{};for(var c in a)b[c]=Za(a[c]);return b}return a}
var $a="constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" ");function ab(a,b){for(var c,d,e=1;e<arguments.length;e++){d=arguments[e];for(c in d)a[c]=d[c];for(var f=0;f<$a.length;f++)c=$a[f],Object.prototype.hasOwnProperty.call(d,c)&&(a[c]=d[c])}}
;function bb(a,b){this.f=a===cb&&b||"";this.g=db}
bb.prototype.K=!0;bb.prototype.J=function(){return this.f.toString()};
bb.prototype.ga=!0;bb.prototype.da=function(){return 1};
function eb(a){if(a instanceof bb&&a.constructor===bb&&a.g===db)return a.f;wa(a);return"type_error:TrustedResourceUrl"}
var db={},cb={};var fb=String.prototype.trim?function(a){return a.trim()}:function(a){return/^[\s\xa0]*([\s\S]*?)[\s\xa0]*$/.exec(a)[1]};
function gb(a,b){if(b)a=a.replace(hb,"&amp;").replace(ib,"&lt;").replace(jb,"&gt;").replace(kb,"&quot;").replace(lb,"&#39;").replace(mb,"&#0;");else{if(!nb.test(a))return a;-1!=a.indexOf("&")&&(a=a.replace(hb,"&amp;"));-1!=a.indexOf("<")&&(a=a.replace(ib,"&lt;"));-1!=a.indexOf(">")&&(a=a.replace(jb,"&gt;"));-1!=a.indexOf('"')&&(a=a.replace(kb,"&quot;"));-1!=a.indexOf("'")&&(a=a.replace(lb,"&#39;"));-1!=a.indexOf("\x00")&&(a=a.replace(mb,"&#0;"))}return a}
var hb=/&/g,ib=/</g,jb=/>/g,kb=/"/g,lb=/'/g,mb=/\x00/g,nb=/[\x00&<>"']/;function I(a,b){this.f=a===ob&&b||"";this.g=pb}
I.prototype.K=!0;I.prototype.J=function(){return this.f.toString()};
I.prototype.ga=!0;I.prototype.da=function(){return 1};
function qb(a){if(a instanceof I&&a.constructor===I&&a.g===pb)return a.f;wa(a);return"type_error:SafeUrl"}
var rb=/^(?:(?:https?|mailto|ftp):|[^:/?#]*(?:[/?#]|$))/i;function sb(a){if(a instanceof I)return a;a="object"==typeof a&&a.K?a.J():String(a);rb.test(a)||(a="about:invalid#zClosurez");return new I(ob,a)}
var pb={},ob={};var tb;a:{var ub=x.navigator;if(ub){var vb=ub.userAgent;if(vb){tb=vb;break a}}tb=""}function J(a){return-1!=tb.indexOf(a)}
;function wb(){this.f="";this.h=xb;this.g=null}
wb.prototype.ga=!0;wb.prototype.da=function(){return this.g};
wb.prototype.K=!0;wb.prototype.J=function(){return this.f.toString()};
var xb={};function yb(a,b){var c=new wb;c.f=a;c.g=b;return c}
;function zb(a,b){var c=b instanceof I?b:sb(b);a.href=qb(c)}
function Ab(a,b){a.src=eb(b);var c;(c=a.ownerDocument&&a.ownerDocument.defaultView)&&c!=x?c=ta(c.document):(null===sa&&(sa=ta(x.document)),c=sa);c&&a.setAttribute("nonce",c)}
;function Cb(a){return a=gb(a,void 0)}
function Db(a){for(var b=0,c=0;c<a.length;++c)b=31*b+a.charCodeAt(c)>>>0;return b}
;var Eb=/^(?:([^:/?#.]+):)?(?:\/\/(?:([^\\/?#]*)@)?([^\\/?#]*?)(?::([0-9]+))?(?=[\\/?#]|$))?([^?#]+)?(?:\?([^#]*))?(?:#([\s\S]*))?$/;function K(a){return a?decodeURI(a):a}
function L(a,b){return b.match(Eb)[a]||null}
function Fb(a,b,c){if(Array.isArray(b))for(var d=0;d<b.length;d++)Fb(a,String(b[d]),c);else null!=b&&c.push(a+(""===b?"":"="+encodeURIComponent(String(b))))}
function Gb(a){var b=[],c;for(c in a)Fb(c,a[c],b);return b.join("&")}
function Hb(a,b){var c=Gb(b);if(c){var d=a.indexOf("#");0>d&&(d=a.length);var e=a.indexOf("?");if(0>e||e>d){e=d;var f=""}else f=a.substring(e+1,d);d=[a.substr(0,e),f,a.substr(d)];e=d[1];d[1]=c?e?e+"&"+c:c:e;c=d[0]+(d[1]?"?"+d[1]:"")+d[2]}else c=a;return c}
var Ib=/#|$/;function Jb(a,b){var c=a.search(Ib);a:{var d=0;for(var e=b.length;0<=(d=a.indexOf(b,d))&&d<c;){var f=a.charCodeAt(d-1);if(38==f||63==f)if(f=a.charCodeAt(d+e),!f||61==f||38==f||35==f)break a;d+=e+1}d=-1}if(0>d)return null;e=a.indexOf("&",d);if(0>e||e>c)e=c;d+=b.length+1;return decodeURIComponent(a.substr(d,e-d).replace(/\+/g," "))}
;var Kb=J("Opera"),Lb=J("Trident")||J("MSIE"),Mb=J("Edge"),Nb=J("Gecko")&&!(-1!=tb.toLowerCase().indexOf("webkit")&&!J("Edge"))&&!(J("Trident")||J("MSIE"))&&!J("Edge"),Ob=-1!=tb.toLowerCase().indexOf("webkit")&&!J("Edge");function Pb(){var a=x.document;return a?a.documentMode:void 0}
var Qb;a:{var Rb="",Sb=function(){var a=tb;if(Nb)return/rv:([^\);]+)(\)|;)/.exec(a);if(Mb)return/Edge\/([\d\.]+)/.exec(a);if(Lb)return/\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/.exec(a);if(Ob)return/WebKit\/(\S+)/.exec(a);if(Kb)return/(?:Version)[ \/]?(\S+)/.exec(a)}();
Sb&&(Rb=Sb?Sb[1]:"");if(Lb){var Tb=Pb();if(null!=Tb&&Tb>parseFloat(Rb)){Qb=String(Tb);break a}}Qb=Rb}var Ub=Qb,Vb;if(x.document&&Lb){var Wb=Pb();Vb=Wb?Wb:parseInt(Ub,10)||void 0}else Vb=void 0;var Xb=Vb;var Yb={},Zb=null;var M=window;function $b(a){var b=z("window.location.href");null==a&&(a='Unknown Error of type "null/undefined"');if("string"===typeof a)return{message:a,name:"Unknown error",lineNumber:"Not available",fileName:b,stack:"Not available"};var c=!1;try{var d=a.lineNumber||a.line||"Not available"}catch(f){d="Not available",c=!0}try{var e=a.fileName||a.filename||a.sourceURL||x.$googDebugFname||b}catch(f){e="Not available",c=!0}return!c&&a.lineNumber&&a.fileName&&a.stack&&a.message&&a.name?a:(b=a.message,null==b&&(a.constructor&&
a.constructor instanceof Function?(a.constructor.name?b=a.constructor.name:(b=a.constructor,ac[b]?b=ac[b]:(b=String(b),ac[b]||(c=/function\s+([^\(]+)/m.exec(b),ac[b]=c?c[1]:"[Anonymous]"),b=ac[b])),b='Unknown Error of type "'+b+'"'):b="Unknown Error of unknown type"),{message:b,name:a.name||"UnknownError",lineNumber:d,fileName:e,stack:a.stack||"Not available"})}
var ac={};function bc(a){this.f=a||{cookie:""}}
m=bc.prototype;m.isEnabled=function(){return navigator.cookieEnabled};
m.set=function(a,b,c){var d=!1;if("object"===typeof c){var e=c.wb;d=c.secure||!1;var f=c.domain||void 0;var g=c.path||void 0;var h=c.la}if(/[;=\s]/.test(a))throw Error('Invalid cookie name "'+a+'"');if(/[;\r\n]/.test(b))throw Error('Invalid cookie value "'+b+'"');void 0===h&&(h=-1);c=f?";domain="+f:"";g=g?";path="+g:"";d=d?";secure":"";h=0>h?"":0==h?";expires="+(new Date(1970,1,1)).toUTCString():";expires="+(new Date(C()+1E3*h)).toUTCString();this.f.cookie=a+"="+b+c+g+h+d+(null!=e?";samesite="+e:
"")};
m.get=function(a,b){for(var c=a+"=",d=(this.f.cookie||"").split(";"),e=0,f;e<d.length;e++){f=fb(d[e]);if(0==f.lastIndexOf(c,0))return f.substr(c.length);if(f==a)return""}return b};
m.remove=function(a,b,c){var d=void 0!==this.get(a);this.set(a,"",{la:0,path:b,domain:c});return d};
m.isEmpty=function(){return!this.f.cookie};
m.clear=function(){for(var a=(this.f.cookie||"").split(";"),b=[],c=[],d,e,f=0;f<a.length;f++)e=fb(a[f]),d=e.indexOf("="),-1==d?(b.push(""),c.push(e)):(b.push(e.substring(0,d)),c.push(e.substring(d+1)));for(a=b.length-1;0<=a;a--)this.remove(b[a])};
var cc=new bc("undefined"==typeof document?null:document);var dc=!Lb||9<=Number(Xb);function ec(a,b){this.x=void 0!==a?a:0;this.y=void 0!==b?b:0}
m=ec.prototype;m.clone=function(){return new ec(this.x,this.y)};
m.equals=function(a){return a instanceof ec&&(this==a?!0:this&&a?this.x==a.x&&this.y==a.y:!1)};
m.ceil=function(){this.x=Math.ceil(this.x);this.y=Math.ceil(this.y);return this};
m.floor=function(){this.x=Math.floor(this.x);this.y=Math.floor(this.y);return this};
m.round=function(){this.x=Math.round(this.x);this.y=Math.round(this.y);return this};function fc(a,b){this.width=a;this.height=b}
m=fc.prototype;m.clone=function(){return new fc(this.width,this.height)};
m.aspectRatio=function(){return this.width/this.height};
m.isEmpty=function(){return!(this.width*this.height)};
m.ceil=function(){this.width=Math.ceil(this.width);this.height=Math.ceil(this.height);return this};
m.floor=function(){this.width=Math.floor(this.width);this.height=Math.floor(this.height);return this};
m.round=function(){this.width=Math.round(this.width);this.height=Math.round(this.height);return this};function gc(a){var b=document;return"string"===typeof a?b.getElementById(a):a}
function hc(a,b){Ra(b,function(c,d){c&&"object"==typeof c&&c.K&&(c=c.J());"style"==d?a.style.cssText=c:"class"==d?a.className=c:"for"==d?a.htmlFor=c:ic.hasOwnProperty(d)?a.setAttribute(ic[d],c):0==d.lastIndexOf("aria-",0)||0==d.lastIndexOf("data-",0)?a.setAttribute(d,c):a[d]=c})}
var ic={cellpadding:"cellPadding",cellspacing:"cellSpacing",colspan:"colSpan",frameborder:"frameBorder",height:"height",maxlength:"maxLength",nonce:"nonce",role:"role",rowspan:"rowSpan",type:"type",usemap:"useMap",valign:"vAlign",width:"width"};
function jc(a,b,c){var d=arguments,e=document,f=String(d[0]),g=d[1];if(!dc&&g&&(g.name||g.type)){f=["<",f];g.name&&f.push(' name="',Cb(g.name),'"');if(g.type){f.push(' type="',Cb(g.type),'"');var h={};ab(h,g);delete h.type;g=h}f.push(">");f=f.join("")}f=kc(e,f);g&&("string"===typeof g?f.className=g:Array.isArray(g)?f.className=g.join(" "):hc(f,g));2<d.length&&lc(e,f,d);return f}
function lc(a,b,c){function d(g){g&&b.appendChild("string"===typeof g?a.createTextNode(g):g)}
for(var e=2;e<c.length;e++){var f=c[e];!xa(f)||ya(f)&&0<f.nodeType?d(f):H(mc(f)?Oa(f):f,d)}}
function kc(a,b){b=String(b);"application/xhtml+xml"===a.contentType&&(b=b.toLowerCase());return a.createElement(b)}
function mc(a){if(a&&"number"==typeof a.length){if(ya(a))return"function"==typeof a.item||"string"==typeof a.item;if(A(a))return"function"==typeof a.item}return!1}
function nc(a,b){for(var c=0;a;){if(b(a))return a;a=a.parentNode;c++}return null}
;function oc(a){pc();return new bb(cb,a)}
var pc=ua;function qc(a){var b=rc;if(b)for(var c in b)Object.prototype.hasOwnProperty.call(b,c)&&a.call(void 0,b[c],c,b)}
function sc(){var a=[];qc(function(b){a.push(b)});
return a}
var rc={bb:"allow-forms",cb:"allow-modals",eb:"allow-orientation-lock",fb:"allow-pointer-lock",gb:"allow-popups",hb:"allow-popups-to-escape-sandbox",ib:"allow-presentation",jb:"allow-same-origin",kb:"allow-scripts",lb:"allow-top-navigation",mb:"allow-top-navigation-by-user-activation"},tc=Qa(function(){return sc()});
function uc(){var a=kc(document,"IFRAME"),b={};H(tc(),function(c){a.sandbox&&a.sandbox.supports&&a.sandbox.supports(c)&&(b[c]=!0)});
return b}
;function N(){this.g=this.g;this.C=this.C}
N.prototype.g=!1;N.prototype.dispose=function(){this.g||(this.g=!0,this.o())};
function vc(a,b){a.g?b():(a.C||(a.C=[]),a.C.push(b))}
N.prototype.o=function(){if(this.C)for(;this.C.length;)this.C.shift()()};
function wc(a){a&&"function"==typeof a.dispose&&a.dispose()}
function xc(a){for(var b=0,c=arguments.length;b<c;++b){var d=arguments[b];xa(d)?xc.apply(null,d):wc(d)}}
;function yc(a){"number"==typeof a&&(a=Math.round(a)+"px");return a}
;var zc=(new Date).getTime();function Ac(a){if(!a)return"";a=a.split("#")[0].split("?")[0];a=a.toLowerCase();0==a.indexOf("//")&&(a=window.location.protocol+a);/^[\w\-]*:\/\//.test(a)||(a=window.location.href);var b=a.substring(a.indexOf("://")+3),c=b.indexOf("/");-1!=c&&(b=b.substring(0,c));a=a.substring(0,a.indexOf("://"));if("http"!==a&&"https"!==a&&"chrome-extension"!==a&&"file"!==a&&"android-app"!==a&&"chrome-search"!==a&&"chrome-untrusted"!==a&&"chrome"!==a&&"app"!==a)throw Error("Invalid URI scheme in origin: "+a);c="";
var d=b.indexOf(":");if(-1!=d){var e=b.substring(d+1);b=b.substring(0,d);if("http"===a&&"80"!==e||"https"===a&&"443"!==e)c=":"+e}return a+"://"+b+c}
;function Bc(){function a(){e[0]=1732584193;e[1]=4023233417;e[2]=2562383102;e[3]=271733878;e[4]=3285377520;n=l=0}
function b(r){for(var w=g,t=0;64>t;t+=4)w[t/4]=r[t]<<24|r[t+1]<<16|r[t+2]<<8|r[t+3];for(t=16;80>t;t++)r=w[t-3]^w[t-8]^w[t-14]^w[t-16],w[t]=(r<<1|r>>>31)&4294967295;r=e[0];var F=e[1],W=e[2],ha=e[3],Gc=e[4];for(t=0;80>t;t++){if(40>t)if(20>t){var Ha=ha^F&(W^ha);var Bb=1518500249}else Ha=F^W^ha,Bb=1859775393;else 60>t?(Ha=F&W|ha&(F|W),Bb=2400959708):(Ha=F^W^ha,Bb=3395469782);Ha=((r<<5|r>>>27)&4294967295)+Ha+Gc+Bb+w[t]&4294967295;Gc=ha;ha=W;W=(F<<30|F>>>2)&4294967295;F=r;r=Ha}e[0]=e[0]+r&4294967295;e[1]=
e[1]+F&4294967295;e[2]=e[2]+W&4294967295;e[3]=e[3]+ha&4294967295;e[4]=e[4]+Gc&4294967295}
function c(r,w){if("string"===typeof r){r=unescape(encodeURIComponent(r));for(var t=[],F=0,W=r.length;F<W;++F)t.push(r.charCodeAt(F));r=t}w||(w=r.length);t=0;if(0==l)for(;t+64<w;)b(r.slice(t,t+64)),t+=64,n+=64;for(;t<w;)if(f[l++]=r[t++],n++,64==l)for(l=0,b(f);t+64<w;)b(r.slice(t,t+64)),t+=64,n+=64}
function d(){var r=[],w=8*n;56>l?c(h,56-l):c(h,64-(l-56));for(var t=63;56<=t;t--)f[t]=w&255,w>>>=8;b(f);for(t=w=0;5>t;t++)for(var F=24;0<=F;F-=8)r[w++]=e[t]>>F&255;return r}
for(var e=[],f=[],g=[],h=[128],k=1;64>k;++k)h[k]=0;var l,n;a();return{reset:a,update:c,digest:d,xa:function(){for(var r=d(),w="",t=0;t<r.length;t++)w+="0123456789ABCDEF".charAt(Math.floor(r[t]/16))+"0123456789ABCDEF".charAt(r[t]%16);return w}}}
;function Cc(a,b,c){var d=[],e=[];if(1==(Array.isArray(c)?2:1))return e=[b,a],H(d,function(h){e.push(h)}),Dc(e.join(" "));
var f=[],g=[];H(c,function(h){g.push(h.key);f.push(h.value)});
c=Math.floor((new Date).getTime()/1E3);e=0==f.length?[c,b,a]:[f.join(":"),c,b,a];H(d,function(h){e.push(h)});
a=Dc(e.join(" "));a=[c,a];0==g.length||a.push(g.join(""));return a.join("_")}
function Dc(a){var b=Bc();b.update(a);return b.xa().toLowerCase()}
;function Ec(a){var b=Ac(String(x.location.href)),c;(c=x.__SAPISID||x.__APISID||x.__OVERRIDE_SID)?c=!0:(c=new bc(document),c=c.get("SAPISID")||c.get("APISID")||c.get("__Secure-3PAPISID")||c.get("SID"),c=!!c);if(c&&(c=(b=0==b.indexOf("https:")||0==b.indexOf("chrome-extension:"))?x.__SAPISID:x.__APISID,c||(c=new bc(document),c=c.get(b?"SAPISID":"APISID")||c.get("__Secure-3PAPISID")),c)){b=b?"SAPISIDHASH":"APISIDHASH";var d=String(x.location.href);return d&&c&&b?[b,Cc(Ac(d),c,a||null)].join(" "):null}return null}
;function Fc(){this.g=[];this.f=-1}
Fc.prototype.set=function(a,b){b=void 0===b?!0:b;0<=a&&52>a&&0===a%1&&this.g[a]!=b&&(this.g[a]=b,this.f=-1)};
Fc.prototype.get=function(a){return!!this.g[a]};
function Hc(a){-1==a.f&&(a.f=La(a.g,function(b,c,d){return c?b+Math.pow(2,d):b},0));
return a.f}
;function Ic(a,b){this.h=a;this.i=b;this.g=0;this.f=null}
Ic.prototype.get=function(){if(0<this.g){this.g--;var a=this.f;this.f=a.next;a.next=null}else a=this.h();return a};
function Jc(a,b){a.i(b);100>a.g&&(a.g++,b.next=a.f,a.f=b)}
;function Kc(a){x.setTimeout(function(){throw a;},0)}
var Lc;
function Mc(){var a=x.MessageChannel;"undefined"===typeof a&&"undefined"!==typeof window&&window.postMessage&&window.addEventListener&&!J("Presto")&&(a=function(){var e=kc(document,"IFRAME");e.style.display="none";document.documentElement.appendChild(e);var f=e.contentWindow;e=f.document;e.open();e.close();var g="callImmediate"+Math.random(),h="file:"==f.location.protocol?"*":f.location.protocol+"//"+f.location.host;e=B(function(k){if(("*"==h||k.origin==h)&&k.data==g)this.port1.onmessage()},this);
f.addEventListener("message",e,!1);this.port1={};this.port2={postMessage:function(){f.postMessage(g,h)}}});
if("undefined"!==typeof a&&!J("Trident")&&!J("MSIE")){var b=new a,c={},d=c;b.port1.onmessage=function(){if(void 0!==c.next){c=c.next;var e=c.ka;c.ka=null;e()}};
return function(e){d.next={ka:e};d=d.next;b.port2.postMessage(0)}}return function(e){x.setTimeout(e,0)}}
;function Nc(){this.g=this.f=null}
var Pc=new Ic(function(){return new Oc},function(a){a.reset()});
Nc.prototype.add=function(a,b){var c=Pc.get();c.set(a,b);this.g?this.g.next=c:this.f=c;this.g=c};
Nc.prototype.remove=function(){var a=null;this.f&&(a=this.f,this.f=this.f.next,this.f||(this.g=null),a.next=null);return a};
function Oc(){this.next=this.scope=this.f=null}
Oc.prototype.set=function(a,b){this.f=a;this.scope=b;this.next=null};
Oc.prototype.reset=function(){this.next=this.scope=this.f=null};function Qc(a,b){Rc||Sc();Tc||(Rc(),Tc=!0);Uc.add(a,b)}
var Rc;function Sc(){if(x.Promise&&x.Promise.resolve){var a=x.Promise.resolve(void 0);Rc=function(){a.then(Vc)}}else Rc=function(){var b=Vc;
!A(x.setImmediate)||x.Window&&x.Window.prototype&&!J("Edge")&&x.Window.prototype.setImmediate==x.setImmediate?(Lc||(Lc=Mc()),Lc(b)):x.setImmediate(b)}}
var Tc=!1,Uc=new Nc;function Vc(){for(var a;a=Uc.remove();){try{a.f.call(a.scope)}catch(b){Kc(b)}Jc(Pc,a)}Tc=!1}
;function Wc(){this.g=-1}
;function Xc(){this.g=64;this.f=[];this.l=[];this.m=[];this.i=[];this.i[0]=128;for(var a=1;a<this.g;++a)this.i[a]=0;this.j=this.h=0;this.reset()}
E(Xc,Wc);Xc.prototype.reset=function(){this.f[0]=1732584193;this.f[1]=4023233417;this.f[2]=2562383102;this.f[3]=271733878;this.f[4]=3285377520;this.j=this.h=0};
function Yc(a,b,c){c||(c=0);var d=a.m;if("string"===typeof b)for(var e=0;16>e;e++)d[e]=b.charCodeAt(c)<<24|b.charCodeAt(c+1)<<16|b.charCodeAt(c+2)<<8|b.charCodeAt(c+3),c+=4;else for(e=0;16>e;e++)d[e]=b[c]<<24|b[c+1]<<16|b[c+2]<<8|b[c+3],c+=4;for(e=16;80>e;e++){var f=d[e-3]^d[e-8]^d[e-14]^d[e-16];d[e]=(f<<1|f>>>31)&4294967295}b=a.f[0];c=a.f[1];var g=a.f[2],h=a.f[3],k=a.f[4];for(e=0;80>e;e++){if(40>e)if(20>e){f=h^c&(g^h);var l=1518500249}else f=c^g^h,l=1859775393;else 60>e?(f=c&g|h&(c|g),l=2400959708):
(f=c^g^h,l=3395469782);f=(b<<5|b>>>27)+f+k+l+d[e]&4294967295;k=h;h=g;g=(c<<30|c>>>2)&4294967295;c=b;b=f}a.f[0]=a.f[0]+b&4294967295;a.f[1]=a.f[1]+c&4294967295;a.f[2]=a.f[2]+g&4294967295;a.f[3]=a.f[3]+h&4294967295;a.f[4]=a.f[4]+k&4294967295}
Xc.prototype.update=function(a,b){if(null!=a){void 0===b&&(b=a.length);for(var c=b-this.g,d=0,e=this.l,f=this.h;d<b;){if(0==f)for(;d<=c;)Yc(this,a,d),d+=this.g;if("string"===typeof a)for(;d<b;){if(e[f]=a.charCodeAt(d),++f,++d,f==this.g){Yc(this,e);f=0;break}}else for(;d<b;)if(e[f]=a[d],++f,++d,f==this.g){Yc(this,e);f=0;break}}this.h=f;this.j+=b}};
Xc.prototype.digest=function(){var a=[],b=8*this.j;56>this.h?this.update(this.i,56-this.h):this.update(this.i,this.g-(this.h-56));for(var c=this.g-1;56<=c;c--)this.l[c]=b&255,b/=256;Yc(this,this.l);for(c=b=0;5>c;c++)for(var d=24;0<=d;d-=8)a[b]=this.f[c]>>d&255,++b;return a};function Zc(a){return"string"==typeof a.className?a.className:a.getAttribute&&a.getAttribute("class")||""}
function $c(a,b){"string"==typeof a.className?a.className=b:a.setAttribute&&a.setAttribute("class",b)}
function ad(a,b){if(a.classList)var c=a.classList.contains(b);else c=a.classList?a.classList:Zc(a).match(/\S+/g)||[],c=0<=Ia(c,b);return c}
function bd(){var a=document.body;a.classList?a.classList.remove("inverted-hdpi"):ad(a,"inverted-hdpi")&&$c(a,Ja(a.classList?a.classList:Zc(a).match(/\S+/g)||[],function(b){return"inverted-hdpi"!=b}).join(" "))}
;var cd="StopIteration"in x?x.StopIteration:{message:"StopIteration",stack:""};function dd(){}
dd.prototype.next=function(){throw cd;};
dd.prototype.D=function(){return this};
function ed(a){if(a instanceof dd)return a;if("function"==typeof a.D)return a.D(!1);if(xa(a)){var b=0,c=new dd;c.next=function(){for(;;){if(b>=a.length)throw cd;if(b in a)return a[b++];b++}};
return c}throw Error("Not implemented");}
function fd(a,b){if(xa(a))try{H(a,b,void 0)}catch(c){if(c!==cd)throw c;}else{a=ed(a);try{for(;;)b.call(void 0,a.next(),void 0,a)}catch(c){if(c!==cd)throw c;}}}
function gd(a){if(xa(a))return Oa(a);a=ed(a);var b=[];fd(a,function(c){b.push(c)});
return b}
;function hd(a,b){this.h={};this.f=[];this.F=this.g=0;var c=arguments.length;if(1<c){if(c%2)throw Error("Uneven number of arguments");for(var d=0;d<c;d+=2)this.set(arguments[d],arguments[d+1])}else if(a)if(a instanceof hd)for(c=id(a),d=0;d<c.length;d++)this.set(c[d],a.get(c[d]));else for(d in a)this.set(d,a[d])}
function id(a){jd(a);return a.f.concat()}
m=hd.prototype;m.equals=function(a,b){if(this===a)return!0;if(this.g!=a.g)return!1;var c=b||kd;jd(this);for(var d,e=0;d=this.f[e];e++)if(!c(this.get(d),a.get(d)))return!1;return!0};
function kd(a,b){return a===b}
m.isEmpty=function(){return 0==this.g};
m.clear=function(){this.h={};this.F=this.g=this.f.length=0};
m.remove=function(a){return Object.prototype.hasOwnProperty.call(this.h,a)?(delete this.h[a],this.g--,this.F++,this.f.length>2*this.g&&jd(this),!0):!1};
function jd(a){if(a.g!=a.f.length){for(var b=0,c=0;b<a.f.length;){var d=a.f[b];Object.prototype.hasOwnProperty.call(a.h,d)&&(a.f[c++]=d);b++}a.f.length=c}if(a.g!=a.f.length){var e={};for(c=b=0;b<a.f.length;)d=a.f[b],Object.prototype.hasOwnProperty.call(e,d)||(a.f[c++]=d,e[d]=1),b++;a.f.length=c}}
m.get=function(a,b){return Object.prototype.hasOwnProperty.call(this.h,a)?this.h[a]:b};
m.set=function(a,b){Object.prototype.hasOwnProperty.call(this.h,a)||(this.g++,this.f.push(a),this.F++);this.h[a]=b};
m.forEach=function(a,b){for(var c=id(this),d=0;d<c.length;d++){var e=c[d],f=this.get(e);a.call(b,f,e,this)}};
m.clone=function(){return new hd(this)};
m.D=function(a){jd(this);var b=0,c=this.F,d=this,e=new dd;e.next=function(){if(c!=d.F)throw Error("The map has changed since the iterator was created");if(b>=d.f.length)throw cd;var f=d.f[b++];return a?f:d.h[f]};
return e};function ld(a){var b=[];md(new nd,a,b);return b.join("")}
function nd(){}
function md(a,b,c){if(null==b)c.push("null");else{if("object"==typeof b){if(Array.isArray(b)){var d=b;b=d.length;c.push("[");for(var e="",f=0;f<b;f++)c.push(e),md(a,d[f],c),e=",";c.push("]");return}if(b instanceof String||b instanceof Number||b instanceof Boolean)b=b.valueOf();else{c.push("{");e="";for(d in b)Object.prototype.hasOwnProperty.call(b,d)&&(f=b[d],"function"!=typeof f&&(c.push(e),od(d,c),c.push(":"),md(a,f,c),e=","));c.push("}");return}}switch(typeof b){case "string":od(b,c);break;case "number":c.push(isFinite(b)&&
!isNaN(b)?String(b):"null");break;case "boolean":c.push(String(b));break;case "function":c.push("null");break;default:throw Error("Unknown type: "+typeof b);}}}
var pd={'"':'\\"',"\\":"\\\\","/":"\\/","\b":"\\b","\f":"\\f","\n":"\\n","\r":"\\r","\t":"\\t","\x0B":"\\u000b"},qd=/\uffff/.test("\uffff")?/[\\"\x00-\x1f\x7f-\uffff]/g:/[\\"\x00-\x1f\x7f-\xff]/g;function od(a,b){b.push('"',a.replace(qd,function(c){var d=pd[c];d||(d="\\u"+(c.charCodeAt(0)|65536).toString(16).substr(1),pd[c]=d);return d}),'"')}
;function rd(a){if(!a)return!1;try{return!!a.$goog_Thenable}catch(b){return!1}}
;function O(a){this.f=0;this.m=void 0;this.i=this.g=this.h=null;this.j=this.l=!1;if(a!=ua)try{var b=this;a.call(void 0,function(c){sd(b,2,c)},function(c){sd(b,3,c)})}catch(c){sd(this,3,c)}}
function td(){this.next=this.context=this.onRejected=this.g=this.f=null;this.h=!1}
td.prototype.reset=function(){this.context=this.onRejected=this.g=this.f=null;this.h=!1};
var ud=new Ic(function(){return new td},function(a){a.reset()});
function vd(a,b,c){var d=ud.get();d.g=a;d.onRejected=b;d.context=c;return d}
function wd(a){return new O(function(b,c){c(a)})}
O.prototype.then=function(a,b,c){return xd(this,A(a)?a:null,A(b)?b:null,c)};
O.prototype.$goog_Thenable=!0;function yd(a,b){return xd(a,null,b,void 0)}
O.prototype.cancel=function(a){if(0==this.f){var b=new zd(a);Qc(function(){Ad(this,b)},this)}};
function Ad(a,b){if(0==a.f)if(a.h){var c=a.h;if(c.g){for(var d=0,e=null,f=null,g=c.g;g&&(g.h||(d++,g.f==a&&(e=g),!(e&&1<d)));g=g.next)e||(f=g);e&&(0==c.f&&1==d?Ad(c,b):(f?(d=f,d.next==c.i&&(c.i=d),d.next=d.next.next):Bd(c),Cd(c,e,3,b)))}a.h=null}else sd(a,3,b)}
function Dd(a,b){a.g||2!=a.f&&3!=a.f||Ed(a);a.i?a.i.next=b:a.g=b;a.i=b}
function xd(a,b,c,d){var e=vd(null,null,null);e.f=new O(function(f,g){e.g=b?function(h){try{var k=b.call(d,h);f(k)}catch(l){g(l)}}:f;
e.onRejected=c?function(h){try{var k=c.call(d,h);void 0===k&&h instanceof zd?g(h):f(k)}catch(l){g(l)}}:g});
e.f.h=a;Dd(a,e);return e.f}
O.prototype.w=function(a){this.f=0;sd(this,2,a)};
O.prototype.B=function(a){this.f=0;sd(this,3,a)};
function sd(a,b,c){if(0==a.f){a===c&&(b=3,c=new TypeError("Promise cannot resolve to itself"));a.f=1;a:{var d=c,e=a.w,f=a.B;if(d instanceof O){Dd(d,vd(e||ua,f||null,a));var g=!0}else if(rd(d))d.then(e,f,a),g=!0;else{if(ya(d))try{var h=d.then;if(A(h)){Fd(d,h,e,f,a);g=!0;break a}}catch(k){f.call(a,k);g=!0;break a}g=!1}}g||(a.m=c,a.f=b,a.h=null,Ed(a),3!=b||c instanceof zd||Gd(a,c))}}
function Fd(a,b,c,d,e){function f(k){h||(h=!0,d.call(e,k))}
function g(k){h||(h=!0,c.call(e,k))}
var h=!1;try{b.call(a,g,f)}catch(k){f(k)}}
function Ed(a){a.l||(a.l=!0,Qc(a.C,a))}
function Bd(a){var b=null;a.g&&(b=a.g,a.g=b.next,b.next=null);a.g||(a.i=null);return b}
O.prototype.C=function(){for(var a;a=Bd(this);)Cd(this,a,this.f,this.m);this.l=!1};
function Cd(a,b,c,d){if(3==c&&b.onRejected&&!b.h)for(;a&&a.j;a=a.h)a.j=!1;if(b.f)b.f.h=null,Hd(b,c,d);else try{b.h?b.g.call(b.context):Hd(b,c,d)}catch(e){Id.call(null,e)}Jc(ud,b)}
function Hd(a,b,c){2==b?a.g.call(a.context,c):a.onRejected&&a.onRejected.call(a.context,c)}
function Gd(a,b){a.j=!0;Qc(function(){a.j&&Id.call(null,b)})}
var Id=Kc;function zd(a){G.call(this,a)}
E(zd,G);zd.prototype.name="cancel";function P(a){N.call(this);this.l=1;this.i=[];this.j=0;this.f=[];this.h={};this.m=!!a}
E(P,N);m=P.prototype;m.subscribe=function(a,b,c){var d=this.h[a];d||(d=this.h[a]=[]);var e=this.l;this.f[e]=a;this.f[e+1]=b;this.f[e+2]=c;this.l=e+3;d.push(e);return e};
function Jd(a,b,c,d){if(b=a.h[b]){var e=a.f;(b=Ma(b,function(f){return e[f+1]==c&&e[f+2]==d}))&&a.N(b)}}
m.N=function(a){var b=this.f[a];if(b){var c=this.h[b];0!=this.j?(this.i.push(a),this.f[a+1]=ua):(c&&Na(c,a),delete this.f[a],delete this.f[a+1],delete this.f[a+2])}return!!b};
m.M=function(a,b){var c=this.h[a];if(c){for(var d=Array(arguments.length-1),e=1,f=arguments.length;e<f;e++)d[e-1]=arguments[e];if(this.m)for(e=0;e<c.length;e++){var g=c[e];Kd(this.f[g+1],this.f[g+2],d)}else{this.j++;try{for(e=0,f=c.length;e<f;e++)g=c[e],this.f[g+1].apply(this.f[g+2],d)}finally{if(this.j--,0<this.i.length&&0==this.j)for(;c=this.i.pop();)this.N(c)}}return 0!=e}return!1};
function Kd(a,b,c){Qc(function(){a.apply(b,c)})}
m.clear=function(a){if(a){var b=this.h[a];b&&(H(b,this.N,this),delete this.h[a])}else this.f.length=0,this.h={}};
m.o=function(){P.L.o.call(this);this.clear();this.i.length=0};function Ld(a){this.f=a}
Ld.prototype.set=function(a,b){void 0===b?this.f.remove(a):this.f.set(a,ld(b))};
Ld.prototype.get=function(a){try{var b=this.f.get(a)}catch(c){return}if(null!==b)try{return JSON.parse(b)}catch(c){throw"Storage: Invalid value was encountered";}};
Ld.prototype.remove=function(a){this.f.remove(a)};function Md(a){this.f=a}
E(Md,Ld);function Nd(a){this.data=a}
function Od(a){return void 0===a||a instanceof Nd?a:new Nd(a)}
Md.prototype.set=function(a,b){Md.L.set.call(this,a,Od(b))};
Md.prototype.g=function(a){a=Md.L.get.call(this,a);if(void 0===a||a instanceof Object)return a;throw"Storage: Invalid value was encountered";};
Md.prototype.get=function(a){if(a=this.g(a)){if(a=a.data,void 0===a)throw"Storage: Invalid value was encountered";}else a=void 0;return a};function Pd(a){this.f=a}
E(Pd,Md);Pd.prototype.set=function(a,b,c){if(b=Od(b)){if(c){if(c<C()){Pd.prototype.remove.call(this,a);return}b.expiration=c}b.creation=C()}Pd.L.set.call(this,a,b)};
Pd.prototype.g=function(a){var b=Pd.L.g.call(this,a);if(b){var c=b.creation,d=b.expiration;if(d&&d<C()||c&&c>C())Pd.prototype.remove.call(this,a);else return b}};function Qd(){}
;function Rd(){}
E(Rd,Qd);Rd.prototype.clear=function(){var a=gd(this.D(!0)),b=this;H(a,function(c){b.remove(c)})};function Sd(a){this.f=a}
E(Sd,Rd);m=Sd.prototype;m.isAvailable=function(){if(!this.f)return!1;try{return this.f.setItem("__sak","1"),this.f.removeItem("__sak"),!0}catch(a){return!1}};
m.set=function(a,b){try{this.f.setItem(a,b)}catch(c){if(0==this.f.length)throw"Storage mechanism: Storage disabled";throw"Storage mechanism: Quota exceeded";}};
m.get=function(a){a=this.f.getItem(a);if("string"!==typeof a&&null!==a)throw"Storage mechanism: Invalid value was encountered";return a};
m.remove=function(a){this.f.removeItem(a)};
m.D=function(a){var b=0,c=this.f,d=new dd;d.next=function(){if(b>=c.length)throw cd;var e=c.key(b++);if(a)return e;e=c.getItem(e);if("string"!==typeof e)throw"Storage mechanism: Invalid value was encountered";return e};
return d};
m.clear=function(){this.f.clear()};
m.key=function(a){return this.f.key(a)};function Td(){var a=null;try{a=window.localStorage||null}catch(b){}this.f=a}
E(Td,Sd);function Ud(a,b){this.g=a;this.f=null;if(Lb&&!(9<=Number(Xb))){Vd||(Vd=new hd);this.f=Vd.get(a);this.f||(b?this.f=document.getElementById(b):(this.f=document.createElement("userdata"),this.f.addBehavior("#default#userData"),document.body.appendChild(this.f)),Vd.set(a,this.f));try{this.f.load(this.g)}catch(c){this.f=null}}}
E(Ud,Rd);var Wd={".":".2E","!":".21","~":".7E","*":".2A","'":".27","(":".28",")":".29","%":"."},Vd=null;function Xd(a){return"_"+encodeURIComponent(a).replace(/[.!~*'()%]/g,function(b){return Wd[b]})}
m=Ud.prototype;m.isAvailable=function(){return!!this.f};
m.set=function(a,b){this.f.setAttribute(Xd(a),b);Yd(this)};
m.get=function(a){a=this.f.getAttribute(Xd(a));if("string"!==typeof a&&null!==a)throw"Storage mechanism: Invalid value was encountered";return a};
m.remove=function(a){this.f.removeAttribute(Xd(a));Yd(this)};
m.D=function(a){var b=0,c=this.f.XMLDocument.documentElement.attributes,d=new dd;d.next=function(){if(b>=c.length)throw cd;var e=c[b++];if(a)return decodeURIComponent(e.nodeName.replace(/\./g,"%")).substr(1);e=e.nodeValue;if("string"!==typeof e)throw"Storage mechanism: Invalid value was encountered";return e};
return d};
m.clear=function(){for(var a=this.f.XMLDocument.documentElement,b=a.attributes.length;0<b;b--)a.removeAttribute(a.attributes[b-1].nodeName);Yd(this)};
function Yd(a){try{a.f.save(a.g)}catch(b){throw"Storage mechanism: Quota exceeded";}}
;function Zd(a,b){this.g=a;this.f=b+"::"}
E(Zd,Rd);Zd.prototype.set=function(a,b){this.g.set(this.f+a,b)};
Zd.prototype.get=function(a){return this.g.get(this.f+a)};
Zd.prototype.remove=function(a){this.g.remove(this.f+a)};
Zd.prototype.D=function(a){var b=this.g.D(!0),c=this,d=new dd;d.next=function(){for(var e=b.next();e.substr(0,c.f.length)!=c.f;)e=b.next();return a?e.substr(c.f.length):c.g.get(e)};
return d};function $d(a,b){1<b.length?a[b[0]]=b[1]:1===b.length&&Object.assign(a,b[0])}
;var ae=window.yt&&window.yt.config_||window.ytcfg&&window.ytcfg.data_||{};y("yt.config_",ae,void 0);function Q(a){$d(ae,arguments)}
function R(a,b){return a in ae?ae[a]:b}
function be(){return R("PLAYER_CONFIG",{})}
function ce(a){var b=ae.EXPERIMENT_FLAGS;return b?b[a]:void 0}
;function de(){var a=ee;z("yt.ads.biscotti.getId_")||y("yt.ads.biscotti.getId_",a,void 0)}
function fe(a){y("yt.ads.biscotti.lastId_",a,void 0)}
;var ge=[];function he(a){ge.forEach(function(b){return b(a)})}
function ie(a){return a&&window.yterr?function(){try{return a.apply(this,arguments)}catch(b){je(b),he(b)}}:a}
function je(a){var b=z("yt.logging.errors.log");b?b(a,"ERROR",void 0,void 0,void 0):(b=R("ERRORS",[]),b.push([a,"ERROR",void 0,void 0,void 0]),Q("ERRORS",b))}
function ke(a){var b=z("yt.logging.errors.log");b?b(a,"WARNING",void 0,void 0,void 0):(b=R("ERRORS",[]),b.push([a,"WARNING",void 0,void 0,void 0]),Q("ERRORS",b))}
;function le(a){a=a.split("&");for(var b={},c=0,d=a.length;c<d;c++){var e=a[c].split("=");if(1==e.length&&e[0]||2==e.length)try{var f=decodeURIComponent((e[0]||"").replace(/\+/g," ")),g=decodeURIComponent((e[1]||"").replace(/\+/g," "));f in b?Array.isArray(b[f])?Pa(b[f],g):b[f]=[b[f],g]:b[f]=g}catch(k){if("q"!=e[0]){var h=Error("Error decoding URL component");h.params={key:e[0],value:e[1]};je(h)}}}return b}
function me(a){var b=[];Ra(a,function(c,d){var e=encodeURIComponent(String(d)),f;Array.isArray(c)?f=c:f=[c];H(f,function(g){""==g?b.push(e):b.push(e+"="+encodeURIComponent(String(g)))})});
return b.join("&")}
function ne(a){"?"==a.charAt(0)&&(a=a.substr(1));return le(a)}
function oe(a,b){return pe(a,b||{},!0)}
function pe(a,b,c){var d=a.split("#",2);a=d[0];d=1<d.length?"#"+d[1]:"";var e=a.split("?",2);a=e[0];e=ne(e[1]||"");for(var f in b)!c&&null!==e&&f in e||(e[f]=b[f]);return Hb(a,e)+d}
;function qe(a){var b=re;a=void 0===a?z("yt.ads.biscotti.lastId_")||"":a;b=Object.assign(se(b),te(b));b.ca_type="image";a&&(b.bid=a);return b}
function se(a){var b={};b.dt=zc;b.flash="0";a:{try{var c=a.f.top.location.href}catch(f){a=2;break a}a=c?c===a.g.location.href?0:1:2}b=(b.frm=a,b);b.u_tz=-(new Date).getTimezoneOffset();var d=void 0===d?M:d;try{var e=d.history.length}catch(f){e=0}b.u_his=e;b.u_java=!!M.navigator&&"unknown"!==typeof M.navigator.javaEnabled&&!!M.navigator.javaEnabled&&M.navigator.javaEnabled();M.screen&&(b.u_h=M.screen.height,b.u_w=M.screen.width,b.u_ah=M.screen.availHeight,b.u_aw=M.screen.availWidth,b.u_cd=M.screen.colorDepth);
M.navigator&&M.navigator.plugins&&(b.u_nplug=M.navigator.plugins.length);M.navigator&&M.navigator.mimeTypes&&(b.u_nmime=M.navigator.mimeTypes.length);return b}
function te(a){var b=a.f;try{var c=b.screenX;var d=b.screenY}catch(r){}try{var e=b.outerWidth;var f=b.outerHeight}catch(r){}try{var g=b.innerWidth;var h=b.innerHeight}catch(r){}b=[b.screenLeft,b.screenTop,c,d,b.screen?b.screen.availWidth:void 0,b.screen?b.screen.availTop:void 0,e,f,g,h];c=a.f.top;try{var k=(c||window).document,l="CSS1Compat"==k.compatMode?k.documentElement:k.body;var n=(new fc(l.clientWidth,l.clientHeight)).round()}catch(r){n=new fc(-12245933,-12245933)}k=n;n={};l=new Fc;x.SVGElement&&
x.document.createElementNS&&l.set(0);c=uc();c["allow-top-navigation-by-user-activation"]&&l.set(1);c["allow-popups-to-escape-sandbox"]&&l.set(2);x.crypto&&x.crypto.subtle&&l.set(3);x.TextDecoder&&x.TextEncoder&&l.set(4);l=Hc(l);n.bc=l;n.bih=k.height;n.biw=k.width;n.brdim=b.join();a=a.g;return n.vis={visible:1,hidden:2,prerender:3,preview:4,unloaded:5}[a.visibilityState||a.webkitVisibilityState||a.mozVisibilityState||""]||0,n.wgl=!!M.WebGLRenderingContext,n}
var re=new function(){var a=window.document;this.f=window;this.g=a};
y("yt.ads_.signals_.getAdSignalsString",function(a){return me(qe(a))},void 0);C();function S(a){a=ue(a);return"string"===typeof a&&"false"===a?!1:!!a}
function ve(a,b){var c=ue(a);return void 0===c&&void 0!==b?b:Number(c||0)}
function ue(a){var b=R("EXPERIMENTS_FORCED_FLAGS",{});return void 0!==b[a]?b[a]:R("EXPERIMENT_FLAGS",{})[a]}
;var we=void 0!==XMLHttpRequest?function(){return new XMLHttpRequest}:void 0!==ActiveXObject?function(){return new ActiveXObject("Microsoft.XMLHTTP")}:null;
function xe(){if(!we)return null;var a=we();return"open"in a?a:null}
function ye(a){switch(a&&"status"in a?a.status:-1){case 200:case 201:case 202:case 203:case 204:case 205:case 206:case 304:return!0;default:return!1}}
;function T(a,b){A(a)&&(a=ie(a));return window.setTimeout(a,b)}
function U(a){window.clearTimeout(a)}
;var ze={Authorization:"AUTHORIZATION","X-Goog-Visitor-Id":"SANDBOXED_VISITOR_ID","X-YouTube-Client-Name":"INNERTUBE_CONTEXT_CLIENT_NAME","X-YouTube-Client-Version":"INNERTUBE_CONTEXT_CLIENT_VERSION","X-YouTube-Device":"DEVICE","X-Youtube-Identity-Token":"ID_TOKEN","X-YouTube-Page-CL":"PAGE_CL","X-YouTube-Page-Label":"PAGE_BUILD_LABEL","X-YouTube-Variants-Checksum":"VARIANTS_CHECKSUM"},Ae="app debugcss debugjs expflag force_ad_params force_viral_ad_response_params forced_experiments innertube_snapshots innertube_goldens internalcountrycode internalipoverride absolute_experiments conditional_experiments sbb sr_bns_address".split(" "),
Be=!1;
function Ce(a,b){b=void 0===b?{}:b;if(!c)var c=window.location.href;var d=L(1,a),e=K(L(3,a));d&&e?(d=c,c=a.match(Eb),d=d.match(Eb),c=c[3]==d[3]&&c[1]==d[1]&&c[4]==d[4]):c=e?K(L(3,c))==e&&(Number(L(4,c))||null)==(Number(L(4,a))||null):!0;d=S("web_ajax_ignore_global_headers_if_set");for(var f in ze)e=R(ze[f]),!e||!c&&!De(a,f)||d&&void 0!==b[f]||(b[f]=e);if(c||De(a,"X-YouTube-Utc-Offset"))b["X-YouTube-Utc-Offset"]=String(-(new Date).getTimezoneOffset());(c||De(a,"X-YouTube-Time-Zone"))&&(f="undefined"!=typeof Intl?
(new Intl.DateTimeFormat).resolvedOptions().timeZone:null)&&(b["X-YouTube-Time-Zone"]=f);if(c||De(a,"X-YouTube-Ad-Signals"))b["X-YouTube-Ad-Signals"]=me(qe(void 0));return b}
function Ee(a){var b=window.location.search,c=K(L(3,a)),d=K(L(5,a));d=(c=c&&(c.endsWith("youtube.com")||c.endsWith("youtube-nocookie.com")))&&d&&d.startsWith("/api/");if(!c||d)return a;var e=ne(b),f={};H(Ae,function(g){e[g]&&(f[g]=e[g])});
return pe(a,f||{},!1)}
function De(a,b){var c=R("CORS_HEADER_WHITELIST")||{},d=K(L(3,a));return d?(c=c[d])?0<=Ia(c,b):!1:!0}
function Fe(a,b){if(window.fetch&&"XML"!=b.format){var c={method:b.method||"GET",credentials:"same-origin"};b.headers&&(c.headers=b.headers);a=Ge(a,b);var d=He(a,b);d&&(c.body=d);b.withCredentials&&(c.credentials="include");var e=!1,f;fetch(a,c).then(function(g){if(!e){e=!0;f&&U(f);var h=g.ok,k=function(l){l=l||{};var n=b.context||x;h?b.onSuccess&&b.onSuccess.call(n,l,g):b.onError&&b.onError.call(n,l,g);b.ia&&b.ia.call(n,l,g)};
"JSON"==(b.format||"JSON")&&(h||400<=g.status&&500>g.status)?g.json().then(k,function(){k(null)}):k(null)}});
b.oa&&0<b.timeout&&(f=T(function(){e||(e=!0,U(f),b.oa.call(b.context||x))},b.timeout))}else Ie(a,b)}
function Ie(a,b){var c=b.format||"JSON";a=Ge(a,b);var d=He(a,b),e=!1,f,g=Je(a,function(h){if(!e){e=!0;f&&U(f);var k=ye(h),l=null,n=400<=h.status&&500>h.status,r=500<=h.status&&600>h.status;if(k||n||r)l=Ke(c,h,b.qb);if(k)a:if(h&&204==h.status)k=!0;else{switch(c){case "XML":k=0==parseInt(l&&l.return_code,10);break a;case "RAW":k=!0;break a}k=!!l}l=l||{};n=b.context||x;k?b.onSuccess&&b.onSuccess.call(n,h,l):b.onError&&b.onError.call(n,h,l);b.ia&&b.ia.call(n,h,l)}},b.method,d,b.headers,b.responseType,
b.withCredentials);
b.O&&0<b.timeout&&(f=T(function(){e||(e=!0,g.abort(),U(f),b.O.call(b.context||x,g))},b.timeout));
return g}
function Ge(a,b){b.tb&&(a=document.location.protocol+"//"+document.location.hostname+(document.location.port?":"+document.location.port:"")+a);var c=R("XSRF_FIELD_NAME",void 0),d=b.Za;d&&(d[c]&&delete d[c],a=oe(a,d));return a}
function He(a,b){var c=R("XSRF_FIELD_NAME",void 0),d=R("XSRF_TOKEN",void 0),e=b.postBody||"",f=b.A,g=R("XSRF_FIELD_NAME",void 0),h;b.headers&&(h=b.headers["Content-Type"]);b.sb||K(L(3,a))&&!b.withCredentials&&K(L(3,a))!=document.location.hostname||"POST"!=b.method||h&&"application/x-www-form-urlencoded"!=h||b.A&&b.A[g]||(f||(f={}),f[c]=d);f&&"string"===typeof e&&(e=ne(e),ab(e,f),e=b.qa&&"JSON"==b.qa?JSON.stringify(e):Gb(e));f=e||f&&!Va(f);!Be&&f&&"POST"!=b.method&&(Be=!0,je(Error("AJAX request with postData should use POST")));
return e}
function Ke(a,b,c){var d=null;switch(a){case "JSON":a=b.responseText;b=b.getResponseHeader("Content-Type")||"";a&&0<=b.indexOf("json")&&(d=JSON.parse(a));break;case "XML":if(b=(b=b.responseXML)?Le(b):null)d={},H(b.getElementsByTagName("*"),function(e){d[e.tagName]=Me(e)})}c&&Ne(d);
return d}
function Ne(a){if(ya(a))for(var b in a){var c;(c="html_content"==b)||(c=b.length-5,c=0<=c&&b.indexOf("_html",c)==c);if(c){c=b;var d=yb(a[b],null);a[c]=d}else Ne(a[b])}}
function Le(a){return a?(a=("responseXML"in a?a.responseXML:a).getElementsByTagName("root"))&&0<a.length?a[0]:null:null}
function Me(a){var b="";H(a.childNodes,function(c){b+=c.nodeValue});
return b}
function Je(a,b,c,d,e,f,g){function h(){4==(k&&"readyState"in k?k.readyState:0)&&b&&ie(b)(k)}
c=void 0===c?"GET":c;d=void 0===d?"":d;var k=xe();if(!k)return null;"onloadend"in k?k.addEventListener("loadend",h,!1):k.onreadystatechange=h;S("debug_forward_web_query_parameters")&&(a=Ee(a));k.open(c,a,!0);f&&(k.responseType=f);g&&(k.withCredentials=!0);c="POST"==c&&(void 0===window.FormData||!(d instanceof FormData));if(e=Ce(a,e))for(var l in e)k.setRequestHeader(l,e[l]),"content-type"==l.toLowerCase()&&(c=!1);c&&k.setRequestHeader("Content-Type","application/x-www-form-urlencoded");k.send(d);
return k}
;var Oe={},Pe=0;
function Qe(a,b,c,d,e){e=void 0===e?"":e;a&&(c&&(c=tb,c=!(c&&0<=c.toLowerCase().indexOf("cobalt"))),c?a&&(a instanceof I||(a="object"==typeof a&&a.K?a.J():String(a),rb.test(a)||(a="about:invalid#zClosurez"),a=new I(ob,a)),b=qb(a),"about:invalid#zClosurez"===b?a="":(b instanceof wb?a=b:(d="object"==typeof b,a=null,d&&b.ga&&(a=b.da()),b=gb(d&&b.K?b.J():String(b)),a=yb(b,a)),a instanceof wb&&a.constructor===wb&&a.h===xb?a=a.f:(wa(a),a="type_error:SafeHtml"),a=encodeURIComponent(String(ld(a.toString())))),/^[\s\xa0]*$/.test(a)||
(a=jc("IFRAME",{src:'javascript:"<body><img src=\\""+'+a+'+"\\"></body>"',style:"display:none"}),(9==a.nodeType?a:a.ownerDocument||a.document).body.appendChild(a))):e?Je(a,b,"POST",e,d):R("USE_NET_AJAX_FOR_PING_TRANSPORT",!1)||d?Je(a,b,"GET","",d):Re(a,b)||Se(a,b))}
function Re(a,b){if(!ce("web_use_beacon_api_for_ad_click_server_pings"))return!1;if(ce("use_sonic_js_library_for_v4_support")){a:{try{var c=new Ga({url:a,ab:!0});if(c.j?c.h&&c.f&&c.f[1]||c.i:c.g){var d=K(L(5,a));var e=!(!d||!d.endsWith("/aclk")||"1"!==Jb(a,"ri"));break a}}catch(f){}e=!1}if(!e)return!1}else if(e=K(L(5,a)),!e||-1==e.indexOf("/aclk")||"1"!==Jb(a,"ae")||"1"!==Jb(a,"act"))return!1;return Te(a)?(b&&b(),!0):!1}
function Te(a,b){try{if(window.navigator&&window.navigator.sendBeacon&&window.navigator.sendBeacon(a,void 0===b?"":b))return!0}catch(c){}return!1}
function Se(a,b){var c=new Image,d=""+Pe++;Oe[d]=c;c.onload=c.onerror=function(){b&&Oe[d]&&b();delete Oe[d]};
c.src=a}
;var Ue=z("ytPubsubPubsubInstance")||new P;P.prototype.subscribe=P.prototype.subscribe;P.prototype.unsubscribeByKey=P.prototype.N;P.prototype.publish=P.prototype.M;P.prototype.clear=P.prototype.clear;y("ytPubsubPubsubInstance",Ue,void 0);var Ve=z("ytPubsubPubsubSubscribedKeys")||{};y("ytPubsubPubsubSubscribedKeys",Ve,void 0);var We=z("ytPubsubPubsubTopicToKeys")||{};y("ytPubsubPubsubTopicToKeys",We,void 0);var Xe=z("ytPubsubPubsubIsSynchronous")||{};y("ytPubsubPubsubIsSynchronous",Xe,void 0);
function Ye(a,b){var c=Ze();if(c){var d=c.subscribe(a,function(){var e=arguments;var f=function(){Ve[d]&&b.apply&&"function"==typeof b.apply&&b.apply(window,e)};
try{Xe[a]?f():T(f,0)}catch(g){je(g)}},void 0);
Ve[d]=!0;We[a]||(We[a]=[]);We[a].push(d);return d}return 0}
function $e(a){var b=Ze();b&&("number"===typeof a?a=[a]:"string"===typeof a&&(a=[parseInt(a,10)]),H(a,function(c){b.unsubscribeByKey(c);delete Ve[c]}))}
function af(a,b){var c=Ze();c&&c.publish.apply(c,arguments)}
function bf(a){var b=Ze();if(b)if(b.clear(a),a)cf(a);else for(var c in We)cf(c)}
function Ze(){return z("ytPubsubPubsubInstance")}
function cf(a){We[a]&&(a=We[a],H(a,function(b){Ve[b]&&delete Ve[b]}),a.length=0)}
;var df=window,V=df.ytcsi&&df.ytcsi.now?df.ytcsi.now:df.performance&&df.performance.timing&&df.performance.now&&df.performance.timing.navigationStart?function(){return df.performance.timing.navigationStart+df.performance.now()}:function(){return(new Date).getTime()};var ef=ve("initial_gel_batch_timeout",1E3),ff=Math.pow(2,16)-1,gf=null,hf=0,jf=void 0,kf=0,lf=0,mf=0,nf=!0,of=z("ytLoggingTransportLogPayloadsQueue_")||{};y("ytLoggingTransportLogPayloadsQueue_",of,void 0);var pf=z("ytLoggingTransportGELQueue_")||new Map;y("ytLoggingTransportGELQueue_",pf,void 0);var qf=z("ytLoggingTransportTokensToCttTargetIds_")||{};y("ytLoggingTransportTokensToCttTargetIds_",qf,void 0);
function rf(){U(kf);U(lf);lf=0;jf&&jf.isReady()?(sf(pf),"log_event"in of&&sf(Object.entries(of.log_event)),pf.clear(),delete of.log_event):tf()}
function tf(){S("web_gel_timeout_cap")&&!lf&&(lf=T(rf,6E4));U(kf);var a=R("LOGGING_BATCH_TIMEOUT",ve("web_gel_debounce_ms",1E4));S("shorten_initial_gel_batch_timeout")&&nf&&(a=ef);kf=T(rf,a)}
function sf(a){var b=jf,c=Math.round(V());a=p(a);for(var d=a.next();!d.done;d=a.next()){var e=p(d.value);d=e.next().value;var f=e.next().value;e=Za({context:uf(b.f||vf())});e.events=f;(f=qf[d])&&wf(e,d,f);delete qf[d];xf(e,c);yf(b,"log_event",e,{retry:!0,onSuccess:function(){hf=Math.round(V()-c)}});
nf=!1}}
function xf(a,b){a.requestTimeMs=String(b);S("unsplit_gel_payloads_in_logs")&&(a.unsplitGelPayloadsInLogs=!0);var c=R("EVENT_ID",void 0);if(c){var d=R("BATCH_CLIENT_COUNTER",void 0)||0;!d&&S("web_client_counter_random_seed")&&(d=Math.floor(Math.random()*ff/2));d++;d>ff&&(d=1);Q("BATCH_CLIENT_COUNTER",d);c={serializedEventId:c,clientCounter:String(d)};a.serializedClientEventId=c;gf&&hf&&S("log_gel_rtt_web")&&(a.previousBatchInfo={serializedClientEventId:gf,roundtripMs:String(hf)});gf=c;hf=0}}
function wf(a,b,c){if(c.videoId)var d="VIDEO";else if(c.playlistId)d="PLAYLIST";else return;a.credentialTransferTokenTargetId=c;a.context=a.context||{};a.context.user=a.context.user||{};a.context.user.credentialTransferTokens=[{token:b,scope:d}]}
;var zf=0;y("ytDomDomGetNextId",z("ytDomDomGetNextId")||function(){return++zf},void 0);var Af={stopImmediatePropagation:1,stopPropagation:1,preventMouseEvent:1,preventManipulation:1,preventDefault:1,layerX:1,layerY:1,screenX:1,screenY:1,scale:1,rotation:1,webkitMovementX:1,webkitMovementY:1};
function Bf(a){this.type="";this.state=this.source=this.data=this.currentTarget=this.relatedTarget=this.target=null;this.charCode=this.keyCode=0;this.metaKey=this.shiftKey=this.ctrlKey=this.altKey=!1;this.clientY=this.clientX=0;this.changedTouches=this.touches=null;try{if(a=a||window.event){this.event=a;for(var b in a)b in Af||(this[b]=a[b]);var c=a.target||a.srcElement;c&&3==c.nodeType&&(c=c.parentNode);this.target=c;var d=a.relatedTarget;if(d)try{d=d.nodeName?d:null}catch(e){d=null}else"mouseover"==
this.type?d=a.fromElement:"mouseout"==this.type&&(d=a.toElement);this.relatedTarget=d;this.clientX=void 0!=a.clientX?a.clientX:a.pageX;this.clientY=void 0!=a.clientY?a.clientY:a.pageY;this.keyCode=a.keyCode?a.keyCode:a.which;this.charCode=a.charCode||("keypress"==this.type?this.keyCode:0);this.altKey=a.altKey;this.ctrlKey=a.ctrlKey;this.shiftKey=a.shiftKey;this.metaKey=a.metaKey;this.f=a.pageX;this.g=a.pageY}}catch(e){}}
function Cf(a){if(document.body&&document.documentElement){var b=document.body.scrollTop+document.documentElement.scrollTop;a.f=a.clientX+(document.body.scrollLeft+document.documentElement.scrollLeft);a.g=a.clientY+b}}
Bf.prototype.preventDefault=function(){this.event&&(this.event.returnValue=!1,this.event.preventDefault&&this.event.preventDefault())};
Bf.prototype.stopPropagation=function(){this.event&&(this.event.cancelBubble=!0,this.event.stopPropagation&&this.event.stopPropagation())};
Bf.prototype.stopImmediatePropagation=function(){this.event&&(this.event.cancelBubble=!0,this.event.stopImmediatePropagation&&this.event.stopImmediatePropagation())};var Ua=z("ytEventsEventsListeners")||{};y("ytEventsEventsListeners",Ua,void 0);var Df=z("ytEventsEventsCounter")||{count:0};y("ytEventsEventsCounter",Df,void 0);
function Ef(a,b,c,d){d=void 0===d?{}:d;a.addEventListener&&("mouseenter"!=b||"onmouseenter"in document?"mouseleave"!=b||"onmouseenter"in document?"mousewheel"==b&&"MozBoxSizing"in document.documentElement.style&&(b="MozMousePixelScroll"):b="mouseout":b="mouseover");return Ta(function(e){var f="boolean"===typeof e[4]&&e[4]==!!d,g=ya(e[4])&&ya(d)&&Xa(e[4],d);return!!e.length&&e[0]==a&&e[1]==b&&e[2]==c&&(f||g)})}
var Ff=Qa(function(){var a=!1;try{var b=Object.defineProperty({},"capture",{get:function(){a=!0}});
window.addEventListener("test",null,b)}catch(c){}return a});
function X(a,b,c,d){d=void 0===d?{}:d;if(!a||!a.addEventListener&&!a.attachEvent)return"";var e=Ef(a,b,c,d);if(e)return e;e=++Df.count+"";var f=!("mouseenter"!=b&&"mouseleave"!=b||!a.addEventListener||"onmouseenter"in document);var g=f?function(h){h=new Bf(h);if(!nc(h.relatedTarget,function(k){return k==a}))return h.currentTarget=a,h.type=b,c.call(a,h)}:function(h){h=new Bf(h);
h.currentTarget=a;return c.call(a,h)};
g=ie(g);a.addEventListener?("mouseenter"==b&&f?b="mouseover":"mouseleave"==b&&f?b="mouseout":"mousewheel"==b&&"MozBoxSizing"in document.documentElement.style&&(b="MozMousePixelScroll"),Ff()||"boolean"===typeof d?a.addEventListener(b,g,d):a.addEventListener(b,g,!!d.capture)):a.attachEvent("on"+b,g);Ua[e]=[a,b,c,g,d];return e}
function Gf(a){a&&("string"==typeof a&&(a=[a]),H(a,function(b){if(b in Ua){var c=Ua[b],d=c[0],e=c[1],f=c[3];c=c[4];d.removeEventListener?Ff()||"boolean"===typeof c?d.removeEventListener(e,f,c):d.removeEventListener(e,f,!!c.capture):d.detachEvent&&d.detachEvent("on"+e,f);delete Ua[b]}}))}
;var Hf=window.ytcsi&&window.ytcsi.now?window.ytcsi.now:window.performance&&window.performance.timing&&window.performance.now&&window.performance.timing.navigationStart?function(){return window.performance.timing.navigationStart+window.performance.now()}:function(){return(new Date).getTime()};function If(a){this.w=a;this.f=null;this.j=0;this.m=null;this.l=0;this.h=[];for(a=0;4>a;a++)this.h.push(0);this.i=0;this.G=X(window,"mousemove",B(this.H,this));a=B(this.B,this);A(a)&&(a=ie(a));this.I=window.setInterval(a,25)}
E(If,N);If.prototype.H=function(a){void 0===a.f&&Cf(a);var b=a.f;void 0===a.g&&Cf(a);this.f=new ec(b,a.g)};
If.prototype.B=function(){if(this.f){var a=Hf();if(0!=this.j){var b=this.m,c=this.f,d=b.x-c.x;b=b.y-c.y;d=Math.sqrt(d*d+b*b)/(a-this.j);this.h[this.i]=.5<Math.abs((d-this.l)/this.l)?1:0;for(c=b=0;4>c;c++)b+=this.h[c]||0;3<=b&&this.w();this.l=d}this.j=a;this.m=this.f;this.i=(this.i+1)%4}};
If.prototype.o=function(){window.clearInterval(this.I);Gf(this.G)};function Jf(){}
function Kf(a,b){return Lf(a,1,b)}
;function Mf(){}
u(Mf,Jf);function Lf(a,b,c){isNaN(c)&&(c=void 0);var d=z("yt.scheduler.instance.addJob");return d?d(a,b,c):void 0===c?(a(),NaN):T(a,c||0)}
Mf.prototype.start=function(){var a=z("yt.scheduler.instance.start");a&&a()};
Mf.prototype.pause=function(){var a=z("yt.scheduler.instance.pause");a&&a()};
va(Mf);Mf.getInstance();var Nf={};
function Of(a){var b=void 0===a?{}:a;a=void 0===b.Da?!0:b.Da;b=void 0===b.Oa?!1:b.Oa;if(null==z("_lact",window)){var c=parseInt(R("LACT"),10);c=isFinite(c)?C()-Math.max(c,0):-1;y("_lact",c,window);y("_fact",c,window);-1==c&&Pf();X(document,"keydown",Pf);X(document,"keyup",Pf);X(document,"mousedown",Pf);X(document,"mouseup",Pf);a&&(b?X(window,"touchmove",function(){Qf("touchmove",200)},{passive:!0}):(X(window,"resize",function(){Qf("resize",200)}),X(window,"scroll",function(){Qf("scroll",200)})));
new If(function(){Qf("mouse",100)});
X(document,"touchstart",Pf,{passive:!0});X(document,"touchend",Pf,{passive:!0})}}
function Qf(a,b){Nf[a]||(Nf[a]=!0,Kf(function(){Pf();Nf[a]=!1},b))}
function Pf(){null==z("_lact",window)&&Of();var a=C();y("_lact",a,window);-1==z("_fact",window)&&y("_fact",a,window);(a=z("ytglobal.ytUtilActivityCallback_"))&&a()}
function Rf(){var a=z("_lact",window);return null==a?-1:Math.max(C()-a,0)}
;var Sf=z("ytLoggingGelSequenceIdObj_")||{};y("ytLoggingGelSequenceIdObj_",Sf,void 0);
function Tf(a,b,c,d){d=void 0===d?{}:d;var e={};e.eventTimeMs=Math.round(d.timestamp||V());e[a]=b;e.context={lastActivityMs:String(d.timestamp?-1:Rf())};S("log_sequence_info_on_gel_web")&&d.P&&(a=e.context,b=d.P,Sf[b]=b in Sf?Sf[b]+1:0,a.sequence={index:Sf[b],groupKey:b},d.rb&&delete Sf[d.P]);d=d.ca;a="";d&&(a={},d.videoId?a.videoId=d.videoId:d.playlistId&&(a.playlistId=d.playlistId),qf[d.token]=a,a=d.token);d=pf.get(a)||[];pf.set(a,d);d.push(e);c&&(jf=new c);c=ve("web_logging_max_batch")||100;e=
V();d.length>=c?rf():10<=e-mf&&(tf(),mf=e)}
;function Uf(){for(var a={},b=p(Object.entries(ne(R("DEVICE","")))),c=b.next();!c.done;c=b.next()){var d=p(c.value);c=d.next().value;d=d.next().value;"cbrand"===c?a.deviceMake=d:"cmodel"===c?a.deviceModel=d:"cbr"===c?a.browserName=d:"cbrver"===c?a.browserVersion=d:"cos"===c?a.osName=d:"cosver"===c?a.osVersion=d:"cplatform"===c&&(a.platform=d)}return a}
;function Vf(){return"INNERTUBE_API_KEY"in ae&&"INNERTUBE_API_VERSION"in ae}
function vf(){return{innertubeApiKey:R("INNERTUBE_API_KEY",void 0),innertubeApiVersion:R("INNERTUBE_API_VERSION",void 0),Ea:R("INNERTUBE_CONTEXT_CLIENT_CONFIG_INFO"),Fa:R("INNERTUBE_CONTEXT_CLIENT_NAME","WEB"),innertubeContextClientVersion:R("INNERTUBE_CONTEXT_CLIENT_VERSION",void 0),Ha:R("INNERTUBE_CONTEXT_HL",void 0),Ga:R("INNERTUBE_CONTEXT_GL",void 0),Ia:R("INNERTUBE_HOST_OVERRIDE",void 0)||"",Ja:!!R("INNERTUBE_USE_THIRD_PARTY_AUTH",!1)}}
function uf(a){a={client:{hl:a.Ha,gl:a.Ga,clientName:a.Fa,clientVersion:a.innertubeContextClientVersion,configInfo:a.Ea}};var b=window.devicePixelRatio;b&&1!=b&&(a.client.screenDensityFloat=String(b));b=R("EXPERIMENTS_TOKEN","");""!==b&&(a.client.experimentsToken=b);b=[];var c=R("EXPERIMENTS_FORCED_FLAGS",{});for(d in c)b.push({key:d,value:String(c[d])});var d=R("EXPERIMENT_FLAGS",{});for(var e in d)e.startsWith("force_")&&void 0===c[e]&&b.push({key:e,value:String(d[e])});0<b.length&&(a.request={internalExperimentFlags:b});
R("DELEGATED_SESSION_ID")&&!S("pageid_as_header_web")&&(a.user={onBehalfOfUser:R("DELEGATED_SESSION_ID")});a.client=Object.assign(a.client,Uf());return a}
function Wf(a,b,c){c=void 0===c?{}:c;var d={"X-Goog-Visitor-Id":c.visitorData||R("VISITOR_DATA","")};if(b&&b.includes("www.youtube-nocookie.com"))return d;(b=c.ob||R("AUTHORIZATION"))||(a?b="Bearer "+z("gapi.auth.getToken")().nb:b=Ec([]));b&&(d.Authorization=b,d["X-Goog-AuthUser"]=R("SESSION_INDEX",0),S("pageid_as_header_web")&&(d["X-Goog-PageId"]=R("DELEGATED_SESSION_ID")));return d}
function Xf(a){a=Object.assign({},a);delete a.Authorization;var b=Ec();if(b){var c=new Xc;c.update(R("INNERTUBE_API_KEY",void 0));c.update(b);b=c.digest();c=3;xa(b);void 0===c&&(c=0);if(!Zb){Zb={};for(var d="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".split(""),e=["+/=","+/","-_=","-_.","-_"],f=0;5>f;f++){var g=d.concat(e[f].split(""));Yb[f]=g;for(var h=0;h<g.length;h++){var k=g[h];void 0===Zb[k]&&(Zb[k]=h)}}}c=Yb[c];d=[];for(e=0;e<b.length;e+=3){var l=b[e],n=(f=e+1<b.length)?
b[e+1]:0;k=(g=e+2<b.length)?b[e+2]:0;h=l>>2;l=(l&3)<<4|n>>4;n=(n&15)<<2|k>>6;k&=63;g||(k=64,f||(n=64));d.push(c[h],c[l],c[n]||"",c[k]||"")}a.hash=d.join("")}return a}
;function Yf(a,b,c,d){cc.set(""+a,b,{la:c,path:"/",domain:void 0===d?"youtube.com":d,secure:!1})}
;function Zf(){var a=new Td;(a=a.isAvailable()?new Zd(a,"yt.innertube"):null)||(a=new Ud("yt.innertube"),a=a.isAvailable()?a:null);this.f=a?new Pd(a):null;this.g=document.domain||window.location.hostname}
Zf.prototype.set=function(a,b,c,d){c=c||31104E3;this.remove(a);if(this.f)try{this.f.set(a,b,C()+1E3*c);return}catch(f){}var e="";if(d)try{e=escape(ld(b))}catch(f){return}else e=escape(b);Yf(a,e,c,this.g)};
Zf.prototype.get=function(a,b){var c=void 0,d=!this.f;if(!d)try{c=this.f.get(a)}catch(e){d=!0}if(d&&(c=cc.get(""+a,void 0))&&(c=unescape(c),b))try{c=JSON.parse(c)}catch(e){this.remove(a),c=void 0}return c};
Zf.prototype.remove=function(a){this.f&&this.f.remove(a);var b=this.g;cc.remove(""+a,"/",void 0===b?"youtube.com":b)};var $f=new Zf;function ag(a,b,c,d){if(d)return null;d=$f.get("nextId",!0)||1;var e=$f.get("requests",!0)||{};e[d]={method:a,request:b,authState:Xf(c),requestTime:Math.round(V())};$f.set("nextId",d+1,86400,!0);$f.set("requests",e,86400,!0);return d}
function bg(a){var b=$f.get("requests",!0)||{};delete b[a];$f.set("requests",b,86400,!0)}
function cg(a){var b=$f.get("requests",!0);if(b){for(var c in b){var d=b[c];if(!(6E4>Math.round(V())-d.requestTime)){var e=d.authState,f=Xf(Wf(!1));Xa(e,f)&&(e=d.request,"requestTimeMs"in e&&(e.requestTimeMs=Math.round(V())),yf(a,d.method,e,{}));delete b[c]}}$f.set("requests",b,86400,!0)}}
;function dg(a){var b=this;this.f=null;a?this.f=a:Vf()&&(this.f=vf());Lf(function(){cg(b)},0,5E3)}
dg.prototype.isReady=function(){!this.f&&Vf()&&(this.f=vf());return!!this.f};
function yf(a,b,c,d){!R("VISITOR_DATA")&&"visitor_id"!==b&&.01>Math.random()&&ke(Error("Missing VISITOR_DATA when sending innertube request."));var e={headers:{"Content-Type":"application/json"},method:"POST",A:c,qa:"JSON",O:function(){d.O()},
oa:d.O,onSuccess:function(w,t){if(d.onSuccess)d.onSuccess(t)},
na:function(w){if(d.onSuccess)d.onSuccess(w)},
onError:function(w,t){if(d.onError)d.onError(t)},
vb:function(w){if(d.onError)d.onError(w)},
timeout:d.timeout,withCredentials:!0},f="",g=a.f.Ia;g&&(f=g);g=a.f.Ja||!1;var h=Wf(g,f,d);Object.assign(e.headers,h);e.headers.Authorization&&!f&&(e.headers["x-origin"]=window.location.origin);var k=oe(""+f+("/youtubei/"+a.f.innertubeApiVersion+"/"+b),{alt:"json",key:a.f.innertubeApiKey}),l;if(d.retry&&S("retry_web_logging_batches")&&"www.youtube-nocookie.com"!=f&&(l=ag(b,c,h,g))){var n=e.onSuccess,r=e.na;e.onSuccess=function(w,t){bg(l);n(w,t)};
c.na=function(w,t){bg(l);r(w,t)}}try{S("use_fetch_for_op_xhr")?Fe(k,e):(e.method="POST",e.A||(e.A={}),Ie(k,e))}catch(w){if("InvalidAccessError"==w)l&&(bg(l),l=0),ke(Error("An extension is blocking network request."));
else throw w;}l&&Lf(function(){cg(a)},0,5E3)}
;function eg(a,b,c){c=void 0===c?{}:c;var d=dg;R("ytLoggingEventsDefaultDisabled",!1)&&dg==dg&&(d=null);Tf(a,b,d,c)}
;function fg(a,b){for(var c=[],d=1;d<arguments.length;++d)c[d-1]=arguments[d];d=Error.call(this,a);this.message=d.message;"stack"in d&&(this.stack=d.stack);this.args=[].concat(c instanceof Array?c:ba(p(c)))}
u(fg,Error);var gg=new Set,hg=0;function ig(a){jg(a,"WARNING")}
function jg(a,b,c,d,e){e=void 0===e?{}:e;e.name=c||R("INNERTUBE_CONTEXT_CLIENT_NAME",1);e.version=d||R("INNERTUBE_CONTEXT_CLIENT_VERSION",void 0);c=e||{};b=void 0===b?"ERROR":b;b=void 0===b?"ERROR":b;d=window&&window.yterr||!1;if(a&&d&&!(5<=hg)&&(S("console_log_js_exceptions")&&(d=[],d.push("Name: "+a.name),d.push("Message: "+a.message),a.hasOwnProperty("params")&&d.push("Error Params: "+JSON.stringify(a.params)),d.push("File name: "+a.fileName),d.push("Stacktrace: "+a.stack),window.console.log(d.join("\n"),
a)),0!==a.f)){d=a.g;e=a.columnNumber;if(a.args&&a.args.length)for(var f=0,g=0;g<a.args.length;g++){var h=a.args[g],k="params."+g;f+=k.length;if(h)if(Array.isArray(h))for(var l=c,n=0;n<h.length&&!(h[n]&&(f+=kg(n,h[n],k,l),500<f));n++);else if("object"===typeof h)for(l in l=void 0,n=c,h){if(h[l]&&(f+=kg(l,h[l],k,n),500<f))break}else c[k]=String(JSON.stringify(h)).substring(0,500),f+=c[k].length;else c[k]=String(JSON.stringify(h)).substring(0,500),f+=c[k].length;if(500<=f)break}else if(a.hasOwnProperty("params"))if(h=
a.params,"object"===typeof a.params)for(g in k=0,h){if(h[g]&&(f="params."+g,l=String(JSON.stringify(h[g])).substr(0,500),c[f]=l,k+=f.length+l.length,500<k))break}else c.params=String(JSON.stringify(h)).substr(0,500);a=$b(a);(d=d||a.stack)||(d="Not available");h={stackTrace:d};a.fileName&&(h.filename=a.fileName);g=a.lineNumber.toString();isNaN(g)||!e||isNaN(e)||(h.lineNumber=Number(g),h.columnNumber=Number(e),g=g+":"+e);window.yterr&&A(window.yterr)&&(a.params=c,window.yterr(a));if(!(gg.has(a.message)||
0<=d.indexOf("/YouTubeCenter.js")||0<=d.indexOf("/mytube.js"))){if(S("kevlar_gel_error_routing")){k=b;e={level:"ERROR_LEVEL_UNKNOWN",message:a.message};"ERROR"===k?e.level="ERROR_LEVEL_ERROR":"WARNING"===k&&(e.level="ERROR_LEVEL_WARNNING");h={isObfuscated:!0,browserStackInfo:h};k={pageUrl:window.location.href,kvPairs:[]};f=p(Object.keys(c));for(l=f.next();!l.done;l=f.next())l=l.value,k.kvPairs.push({key:"client."+l,value:String(c[l])});eg("clientError",{errorMetadata:k,stackTrace:h,logMessage:e});
rf()}b={Za:{a:"logerror",t:"jserror",type:a.name,msg:a.message.substr(0,250),line:g,level:b,"client.name":c.name},A:{url:R("PAGE_NAME",window.location.href),file:a.fileName},method:"POST"};c.version&&(b["client.version"]=c.version);if(b.A){d&&(b.A.stack=d);d=p(Object.keys(c));for(e=d.next();!e.done;e=d.next())e=e.value,b.A["client."+e]=c[e];if(c=R("LATEST_ECATCHER_SERVICE_TRACKING_PARAMS",void 0))for(d=p(Object.keys(c)),e=d.next();!e.done;e=d.next())e=e.value,b.A[e]=c[e];c=R("SERVER_NAME",void 0);
d=R("SERVER_VERSION",void 0);c&&d&&(b.A["server.name"]=c,b.A["server.version"]=d)}Ie(R("ECATCHER_REPORT_HOST","")+"/error_204",b);gg.add(a.message);hg++}}}
function kg(a,b,c,d){c+="."+a;a=String(JSON.stringify(b)).substr(0,500);d[c]=a;return c.length+a.length}
;function lg(a,b,c,d,e,f){jg(a,void 0===b?"ERROR":b,c,d,f)}
;var mg=window.yt&&window.yt.msgs_||window.ytcfg&&window.ytcfg.msgs||{};y("yt.msgs_",mg,void 0);function ng(a){$d(mg,arguments)}
;function og(a){a&&(a.dataset?a.dataset[pg("loaded")]="true":a.setAttribute("data-loaded","true"))}
function qg(a,b){return a?a.dataset?a.dataset[pg(b)]:a.getAttribute("data-"+b):null}
var rg={};function pg(a){return rg[a]||(rg[a]=String(a).replace(/\-([a-z])/g,function(b,c){return c.toUpperCase()}))}
;var sg=/\.vflset|-vfl[a-zA-Z0-9_+=-]+/,tg=/-[a-zA-Z]{2,3}_[a-zA-Z]{2,3}(?=(\/|$))/;function ug(a,b,c){c=void 0===c?null:c;if(window.spf&&spf.script){c="";if(a){var d=a.indexOf("jsbin/"),e=a.lastIndexOf(".js"),f=d+6;-1<d&&-1<e&&e>f&&(c=a.substring(f,e),c=c.replace(sg,""),c=c.replace(tg,""),c=c.replace("debug-",""),c=c.replace("tracing-",""))}spf.script.load(a,c,b)}else vg(a,b,c)}
function vg(a,b,c){c=void 0===c?null:c;var d=wg(a),e=document.getElementById(d),f=e&&qg(e,"loaded"),g=e&&!f;f?b&&b():(b&&(f=Ye(d,b),b=""+za(b),xg[b]=f),g||(e=yg(a,d,function(){qg(e,"loaded")||(og(e),af(d),T(Ea(bf,d),0))},c)))}
function yg(a,b,c,d){d=void 0===d?null:d;var e=kc(document,"SCRIPT");e.id=b;e.onload=function(){c&&setTimeout(c,0)};
e.onreadystatechange=function(){switch(e.readyState){case "loaded":case "complete":e.onload()}};
d&&e.setAttribute("nonce",d);Ab(e,oc(a));a=document.getElementsByTagName("head")[0]||document.body;a.insertBefore(e,a.firstChild);return e}
function zg(a){a=wg(a);var b=document.getElementById(a);b&&(bf(a),b.parentNode.removeChild(b))}
function Ag(a,b){if(a&&b){var c=""+za(b);(c=xg[c])&&$e(c)}}
function wg(a){var b=document.createElement("a");zb(b,a);a=b.href.replace(/^[a-zA-Z]+:\/\//,"//");return"js-"+Db(a)}
var xg={};var Bg=[],Cg=!1;function Dg(){if("1"!=Sa(be(),"args","privembed")){var a=function(){Cg=!0;"google_ad_status"in window?Q("DCLKSTAT",1):Q("DCLKSTAT",2)};
ug("//static.doubleclick.net/instream/ad_status.js",a);Bg.push(Kf(function(){Cg||"google_ad_status"in window||(Ag("//static.doubleclick.net/instream/ad_status.js",a),Cg=!0,Q("DCLKSTAT",3))},5E3))}}
function Eg(){return parseInt(R("DCLKSTAT",0),10)}
;function Fg(){this.g=!1;this.f=null}
Fg.prototype.initialize=function(a,b,c,d,e,f){var g=this;f=void 0===f?!1:f;b?(this.g=!0,ug(b,function(){g.g=!1;window.botguard?Gg(g,c,d,f):(zg(b),ig(new fg("Unable to load Botguard","from "+b)))},e)):a&&(eval(a),window.botguard?Gg(this,c,d,f):ig(Error("Unable to load Botguard from JS")))};
function Gg(a,b,c,d){if(d)try{a.f=new window.botguard.bg(b,c?function(){return c(b)}:ua)}catch(e){ig(e)}else{try{a.f=new window.botguard.bg(b)}catch(e){ig(e)}c&&c(b)}}
Fg.prototype.dispose=function(){this.f=null};var Hg=new Fg,Ig=!1,Jg=0,Kg="";function Lg(a){S("botguard_periodic_refresh")?Jg=V():S("botguard_always_refresh")&&(Kg=a)}
function Mg(a){if(a){if(Hg.g)return!1;if(S("botguard_periodic_refresh"))return 72E5<V()-Jg;if(S("botguard_always_refresh"))return Kg!=a}else return!1;return!Ig}
function Ng(){return!!Hg.f}
function Og(a){a=void 0===a?{}:a;a=void 0===a?{}:a;return Hg.f?Hg.f.invoke(void 0,void 0,a):null}
;var Pg=C().toString();
function Qg(){a:{if(window.crypto&&window.crypto.getRandomValues)try{var a=Array(16),b=new Uint8Array(16);window.crypto.getRandomValues(b);for(var c=0;c<a.length;c++)a[c]=b[c];var d=a;break a}catch(e){}d=Array(16);for(a=0;16>a;a++){b=C();for(c=0;c<b%23;c++)d[a]=Math.random();d[a]=Math.floor(256*Math.random())}if(Pg)for(a=1,b=0;b<Pg.length;b++)d[a%16]=d[a%16]^d[(a-1)%16]/4^Pg.charCodeAt(b),a++}a=[];for(b=0;b<d.length;b++)a.push("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(d[b]&63));
return a.join("")}
;var Rg=z("ytLoggingDocDocumentNonce_")||Qg();y("ytLoggingDocDocumentNonce_",Rg,void 0);var Sg=1;function Tg(a){this.f=a}
function Ug(a){var b={};void 0!==a.f.trackingParams?b.trackingParams=a.f.trackingParams:(b.veType=a.f.veType,void 0!==a.f.veCounter&&(b.veCounter=a.f.veCounter),void 0!==a.f.elementIndex&&(b.elementIndex=a.f.elementIndex));void 0!==a.f.dataElement&&(b.dataElement=Ug(a.f.dataElement));void 0!==a.f.youtubeData&&(b.youtubeData=a.f.youtubeData);return b}
Tg.prototype.toString=function(){return JSON.stringify(Ug(this))};function Vg(a){a=void 0===a?0:a;return 0==a?"client-screen-nonce":"client-screen-nonce."+a}
function Wg(a){a=void 0===a?0:a;return 0==a?"ROOT_VE_TYPE":"ROOT_VE_TYPE."+a}
function Xg(a){return R(Wg(void 0===a?0:a),void 0)}
y("yt_logging_screen.getRootVeType",Xg,void 0);function Yg(){var a=Xg(0),b;a?b=new Tg({veType:a,youtubeData:void 0}):b=null;return b}
function Zg(){var a=R("csn-to-ctt-auth-info");a||(a={},Q("csn-to-ctt-auth-info",a));return a}
function $g(a){a=void 0===a?0:a;var b=R(Vg(a));if(!b&&!R("USE_CSN_FALLBACK",!0))return null;b||0!=a||(S("kevlar_client_side_screens")||S("c3_client_side_screens")?b="UNDEFINED_CSN":b=R("EVENT_ID"));return b?b:null}
y("yt_logging_screen.getCurrentCsn",$g,void 0);function ah(a,b,c){var d=Zg();(c=$g(c))&&delete d[c];b&&(d[a]=b)}
function bh(a){return Zg()[a]}
y("yt_logging_screen.getCttAuthInfo",bh,void 0);function ch(a,b,c,d){c=void 0===c?0:c;if(a!==R(Vg(c))||b!==R(Wg(c)))if(ah(a,d,c),Q(Vg(c),a),Q(Wg(c),b),0==c||S("web_screen_associated_all_layers"))b=function(){setTimeout(function(){a&&Tf("foregroundHeartbeatScreenAssociated",{clientDocumentNonce:Rg,clientScreenNonce:a},dg)},0)},"requestAnimationFrame"in window?window.requestAnimationFrame(b):b()}
y("yt_logging_screen.setCurrentScreen",ch,void 0);function dh(a,b,c){b=void 0===b?{}:b;c=void 0===c?!1:c;var d=R("EVENT_ID");d&&(b.ei||(b.ei=d));if(b){d=a;var e=void 0===e?!0:e;var f=R("VALID_SESSION_TEMPDATA_DOMAINS",[]),g=K(L(3,window.location.href));g&&f.push(g);g=K(L(3,d));if(0<=Ia(f,g)||!g&&0==d.lastIndexOf("/",0))if(S("autoescape_tempdata_url")&&(f=document.createElement("a"),zb(f,d),d=f.href),d){g=d.match(Eb);d=g[5];f=g[6];g=g[7];var h="";d&&(h+=d);f&&(h+="?"+f);g&&(h+="#"+g);d=h;f=d.indexOf("#");if(d=0>f?d:d.substr(0,f))if(e&&!b.csn&&(b.itct||
b.ved)&&(b=Object.assign({csn:$g()},b)),k){var k=parseInt(k,10);isFinite(k)&&0<k&&(e=b,b="ST-"+Db(d).toString(36),e=e?Gb(e):"",Yf(b,e,k||5))}else k=b,e="ST-"+Db(d).toString(36),k=k?Gb(k):"",Yf(e,k,5)}}if(c)return!1;if((window.ytspf||{}).enabled)spf.navigate(a);else{var l=void 0===l?{}:l;var n=void 0===n?"":n;var r=void 0===r?window:r;c=r.location;a=Hb(a,l)+n;a=a instanceof I?a:sb(a);c.href=qb(a)}return!0}
;function eh(a,b){this.version=a;this.args=b}
;function fh(a,b){this.topic=a;this.f=b}
fh.prototype.toString=function(){return this.topic};var gh=z("ytPubsub2Pubsub2Instance")||new P;P.prototype.subscribe=P.prototype.subscribe;P.prototype.unsubscribeByKey=P.prototype.N;P.prototype.publish=P.prototype.M;P.prototype.clear=P.prototype.clear;y("ytPubsub2Pubsub2Instance",gh,void 0);var hh=z("ytPubsub2Pubsub2SubscribedKeys")||{};y("ytPubsub2Pubsub2SubscribedKeys",hh,void 0);var ih=z("ytPubsub2Pubsub2TopicToKeys")||{};y("ytPubsub2Pubsub2TopicToKeys",ih,void 0);var jh=z("ytPubsub2Pubsub2IsAsync")||{};y("ytPubsub2Pubsub2IsAsync",jh,void 0);
y("ytPubsub2Pubsub2SkipSubKey",null,void 0);function kh(a,b){var c=lh();c&&c.publish.call(c,a.toString(),a,b)}
function mh(a){var b=nh,c=lh();if(!c)return 0;var d=c.subscribe(b.toString(),function(e,f){var g=z("ytPubsub2Pubsub2SkipSubKey");g&&g==d||(g=function(){if(hh[d])try{if(f&&b instanceof fh&&b!=e)try{var h=b.f,k=f;if(!k.args||!k.version)throw Error("yt.pubsub2.Data.deserialize(): serializedData is incomplete.");try{if(!h.F){var l=new h;h.F=l.version}var n=h.F}catch(r){}if(!n||k.version!=n)throw Error("yt.pubsub2.Data.deserialize(): serializedData version is incompatible.");try{f=Reflect.construct(h,
Oa(k.args))}catch(r){throw r.message="yt.pubsub2.Data.deserialize(): "+r.message,r;}}catch(r){throw r.message="yt.pubsub2.pubsub2 cross-binary conversion error for "+b.toString()+": "+r.message,r;}a.call(window,f)}catch(r){je(r)}},jh[b.toString()]?z("yt.scheduler.instance")?Kf(g):T(g,0):g())});
hh[d]=!0;ih[b.toString()]||(ih[b.toString()]=[]);ih[b.toString()].push(d);return d}
function oh(){var a=ph,b=mh(function(c){a.apply(void 0,arguments);qh(b)});
return b}
function qh(a){var b=lh();b&&("number"===typeof a&&(a=[a]),H(a,function(c){b.unsubscribeByKey(c);delete hh[c]}))}
function lh(){return z("ytPubsub2Pubsub2Instance")}
;function rh(a){eh.call(this,1,arguments);this.csn=a}
u(rh,eh);var nh=new fh("screen-created",rh),sh=[],th=0;function uh(a,b,c){var d=S("use_default_events_client")?void 0:dg;b={csn:a,parentVe:Ug(b),childVes:Ka(c,function(f){return Ug(f)})};
c=p(c);for(var e=c.next();!e.done;e=c.next())e=Ug(e.value),(Va(e)||!e.trackingParams&&!e.veType)&&lg(Error("Child VE logged with no data"),"WARNING");c={ca:bh(a),P:a};"UNDEFINED_CSN"==a?vh("visualElementAttached",b,c):d?Tf("visualElementAttached",b,d,c):eg("visualElementAttached",b,c)}
function vh(a,b,c){sh.push({payloadName:a,payload:b,options:c});th||(th=oh())}
function ph(a){if(sh){for(var b=p(sh),c=b.next();!c.done;c=b.next())c=c.value,c.payload&&(c.payload.csn=a.csn,Tf(c.payloadName,c.payload,null,c.options));sh.length=0}th=0}
;function wh(a){a=a||{};var b={},c={};this.url=a.url||"";this.args=a.args||Ya(b);this.assets=a.assets||{};this.attrs=a.attrs||Ya(c);this.fallback=a.fallback||null;this.fallbackMessage=a.fallbackMessage||null;this.html5=!!a.html5;this.disable=a.disable||{};this.loaded=!!a.loaded;this.messages=a.messages||{}}
wh.prototype.clone=function(){var a=new wh,b;for(b in this)if(this.hasOwnProperty(b)){var c=this[b];"object"==wa(c)?a[b]=Ya(c):a[b]=c}return a};function xh(){N.call(this);this.f=[]}
u(xh,N);xh.prototype.o=function(){for(;this.f.length;){var a=this.f.pop();a.target.removeEventListener(a.name,a.pb)}N.prototype.o.call(this)};var yh=/cssbin\/(?:debug-)?([a-zA-Z0-9_-]+?)(?:-2x|-web|-rtl|-vfl|.css)/;function zh(a){a=a||"";if(window.spf){var b=a.match(yh);spf.style.load(a,b?b[1]:"",void 0)}else Ah(a)}
function Ah(a){var b=Bh(a),c=document.getElementById(b),d=c&&qg(c,"loaded");d||c&&!d||(c=Ch(a,b,function(){qg(c,"loaded")||(og(c),af(b),T(Ea(bf,b),0))}))}
function Ch(a,b,c){var d=document.createElement("link");d.id=b;d.onload=function(){c&&setTimeout(c,0)};
a=oc(a);d.rel="stylesheet";d.href=eb(a).toString();(document.getElementsByTagName("head")[0]||document.body).appendChild(d);return d}
function Bh(a){var b=kc(document,"A");zb(b,new I(ob,a));a=b.href.replace(/^[a-zA-Z]+:\/\//,"//");return"css-"+Db(a)}
;function Dh(a,b,c,d){N.call(this);var e=this;this.m=this.X=a;this.U=b;this.w=!1;this.api={};this.V=this.G=null;this.H=new P;vc(this,Ea(wc,this.H));this.j={};this.R=this.W=this.h=this.ba=this.f=null;this.I=!1;this.l=this.B=null;this.Y={};this.ta=["onReady"];this.aa=null;this.ja=NaN;this.S={};this.i=d;Eh(this);this.Z("WATCH_LATER_VIDEO_ADDED",this.La.bind(this));this.Z("WATCH_LATER_VIDEO_REMOVED",this.Ma.bind(this));this.Z("onAdAnnounce",this.va.bind(this));this.ua=new xh(this);vc(this,Ea(wc,this.ua));
this.T=0;c?this.T=T(function(){e.loadNewVideoConfig(c)},0):d&&(Fh(this),Gh(this))}
u(Dh,N);m=Dh.prototype;m.getId=function(){return this.U};
m.loadNewVideoConfig=function(a){if(!this.g){this.T&&(U(this.T),this.T=0);a instanceof wh||(a=new wh(a));this.ba=a;this.f=a.clone();Fh(this);this.W||(this.W=Hh(this,this.f.args.jsapicallback||"onYouTubePlayerReady"));this.f.args.jsapicallback=null;if(a=this.f.attrs.width)this.m.style.width=yc(Number(a)||a);if(a=this.f.attrs.height)this.m.style.height=yc(Number(a)||a);Gh(this);this.w&&Ih(this)}};
function Fh(a){var b;a.i?b=a.i.rootElementId:b=a.f.attrs.id;a.h=b||a.h;"video-player"==a.h&&(a.h=a.U,a.f.attrs.id=a.U);a.m.id==a.h&&(a.h+="-player",a.f.attrs.id=a.h)}
m.Aa=function(){return this.ba};
function Ih(a){a.f&&!a.f.loaded&&(a.f.loaded=!0,"0"!=a.f.args.autoplay?a.api.loadVideoByPlayerVars(a.f.args):a.api.cueVideoByPlayerVars(a.f.args))}
function Jh(a){var b=!0,c=Kh(a);c&&a.f&&(a=Lh(a),b=qg(c,"version")===a);return b&&!!z("yt.player.Application.create")}
function Gh(a){if(!a.g&&!a.I){var b=Jh(a);if(b&&"html5"==(Kh(a)?"html5":null))a.R="html5",a.w||Mh(a);else if(Nh(a),a.R="html5",b&&a.l)a.X.appendChild(a.l),Mh(a);else{a.f&&(a.f.loaded=!0);var c=!1;a.B=function(){c=!0;if(a.i)var d=a.i.serializedExperimentFlags;else a.f&&a.f.args&&(d=a.f.args.fflags);d="true"==le(d||"").player_bootstrap_method?z("yt.player.Application.createAlternate")||z("yt.player.Application.create"):z("yt.player.Application.create");var e=a.f?a.f.clone():void 0;d(a.X,e,a.i);Mh(a)};
a.I=!0;b?a.B():(ug(Lh(a),a.B),(b=a.i?a.i.cssUrl:a.f.assets.css)&&zh(b),Oh(a)&&!c&&y("yt.player.Application.create",null,void 0))}}}
function Kh(a){var b=gc(a.h);!b&&a.m&&a.m.querySelector&&(b=a.m.querySelector("#"+a.h));return b}
function Mh(a){if(!a.g){var b=Kh(a),c=!1;b&&b.getApiInterface&&b.getApiInterface()&&(c=!0);c?(a.I=!1,b.isNotServable&&a.f&&b.isNotServable(a.f.args.video_id)||Ph(a)):a.ja=T(function(){Mh(a)},50)}}
function Ph(a){Eh(a);a.w=!0;var b=Kh(a);b.addEventListener&&(a.G=Qh(a,b,"addEventListener"));b.removeEventListener&&(a.V=Qh(a,b,"removeEventListener"));var c=b.getApiInterface();c=c.concat(b.getInternalApiInterface());for(var d=0;d<c.length;d++){var e=c[d];a.api[e]||(a.api[e]=Qh(a,b,e))}for(var f in a.j)a.G(f,a.j[f]);Ih(a);a.W&&a.W(a.api);a.H.M("onReady",a.api)}
function Qh(a,b,c){var d=b[c];return function(){try{return a.aa=null,d.apply(b,arguments)}catch(e){"sendAbandonmentPing"!=c&&(e.params=c,a.aa=e,ke(e))}}}
function Eh(a){a.w=!1;if(a.V)for(var b in a.j)a.V(b,a.j[b]);for(var c in a.S)U(parseInt(c,10));a.S={};a.G=null;a.V=null;for(var d in a.api)a.api[d]=null;a.api.addEventListener=a.Z.bind(a);a.api.removeEventListener=a.Qa.bind(a);a.api.destroy=a.dispose.bind(a);a.api.getLastError=a.Ba.bind(a);a.api.getPlayerType=a.Ca.bind(a);a.api.getCurrentVideoConfig=a.Aa.bind(a);a.api.loadNewVideoConfig=a.loadNewVideoConfig.bind(a);a.api.isReady=a.Ka.bind(a)}
m.Ka=function(){return this.w};
m.Z=function(a,b){var c=this,d=Hh(this,b);if(d){if(!(0<=Ia(this.ta,a)||this.j[a])){var e=Rh(this,a);this.G&&this.G(a,e)}this.H.subscribe(a,d);"onReady"==a&&this.w&&T(function(){d(c.api)},0)}};
m.Qa=function(a,b){if(!this.g){var c=Hh(this,b);c&&Jd(this.H,a,c)}};
function Hh(a,b){var c=b;if("string"==typeof b){if(a.Y[b])return a.Y[b];c=function(){var d=z(b);d&&d.apply(x,arguments)};
a.Y[b]=c}return c?c:null}
function Rh(a,b){var c="ytPlayer"+b+a.U;a.j[b]=c;x[c]=function(d){var e=T(function(){if(!a.g){a.H.M(b,d);var f=a.S,g=String(e);g in f&&delete f[g]}},0);
Wa(a.S,String(e))};
return c}
m.va=function(a){af("a11y-announce",a)};
m.La=function(a){af("WATCH_LATER_VIDEO_ADDED",a)};
m.Ma=function(a){af("WATCH_LATER_VIDEO_REMOVED",a)};
m.Ca=function(){return this.R||(Kh(this)?"html5":null)};
m.Ba=function(){return this.aa};
function Nh(a){a.cancel();Eh(a);a.R=null;a.f&&(a.f.loaded=!1);var b=Kh(a);b&&(Jh(a)||!Oh(a)?a.l=b:(b&&b.destroy&&b.destroy(),a.l=null));for(a=a.X;b=a.firstChild;)a.removeChild(b)}
m.cancel=function(){this.B&&Ag(Lh(this),this.B);U(this.ja);this.I=!1};
m.o=function(){Nh(this);if(this.l&&this.f&&this.l.destroy)try{this.l.destroy()}catch(b){je(b)}this.Y=null;for(var a in this.j)x[this.j[a]]=null;this.ba=this.f=this.api=null;delete this.X;delete this.m;N.prototype.o.call(this)};
function Oh(a){return a.f&&a.f.args&&a.f.args.fflags?-1!=a.f.args.fflags.indexOf("player_destroy_old_version=true"):!1}
function Lh(a){return a.i?a.i.jsUrl:a.f.assets.js}
;var Sh={},Th="player_uid_"+(1E9*Math.random()>>>0);function Uh(a){delete Sh[a.getId()]}
;function Vh(a){return(0===a.search("cue")||0===a.search("load"))&&"loadModule"!==a}
function Wh(a,b,c){"string"===typeof a&&(a={mediaContentUrl:a,startSeconds:b,suggestedQuality:c});a:{if((b=a.mediaContentUrl)&&(b=/\/([ve]|embed)\/([^#?]+)/.exec(b))&&b[2]){b=b[2];break a}b=null}a.videoId=b;return Xh(a)}
function Xh(a,b,c){if("string"===typeof a)return{videoId:a,startSeconds:b,suggestedQuality:c};b=["endSeconds","startSeconds","mediaContentUrl","suggestedQuality","videoId"];c={};for(var d=0;d<b.length;d++){var e=b[d];a[e]&&(c[e]=a[e])}return c}
function Yh(a,b,c,d){if(ya(a)&&!Array.isArray(a)){b="playlist list listType index startSeconds suggestedQuality".split(" ");c={};for(d=0;d<b.length;d++){var e=b[d];a[e]&&(c[e]=a[e])}return c}b={index:b,startSeconds:c,suggestedQuality:d};"string"===typeof a&&16===a.length?b.list="PL"+a:b.playlist=a;return b}
;function Zh(a){a=void 0===a?!1:a;N.call(this);this.f=new P(a);vc(this,Ea(wc,this.f))}
E(Zh,N);Zh.prototype.subscribe=function(a,b,c){return this.g?0:this.f.subscribe(a,b,c)};
Zh.prototype.j=function(a,b){this.g||this.f.M.apply(this.f,arguments)};function $h(a,b,c){Zh.call(this);this.h=a;this.i=b;this.l=c}
u($h,Zh);function ai(a,b,c){if(!a.g){var d=a.h;d.g||a.i!=d.f||(a={id:a.l,command:b},c&&(a.data=c),d.f.postMessage(ld(a),d.i))}}
$h.prototype.o=function(){this.i=this.h=null;Zh.prototype.o.call(this)};function bi(a){N.call(this);this.f=a;this.f.subscribe("command",this.ra,this);this.h={};this.j=!1}
u(bi,N);m=bi.prototype;m.start=function(){this.j||this.g||(this.j=!0,ai(this.f,"RECEIVING"))};
m.ra=function(a,b,c){if(this.j&&!this.g){var d=b||{};switch(a){case "addEventListener":"string"===typeof d.event&&(a=d.event,a in this.h||(c=B(this.Sa,this,a),this.h[a]=c,this.addEventListener(a,c)));break;case "removeEventListener":"string"===typeof d.event&&ci(this,d.event);break;default:this.i.isReady()&&this.i.isExternalMethodAvailable(a,c||null)&&(b=di(a,b||{}),c=this.i.handleExternalCall(a,b,c||null),(c=ei(a,c))&&this.j&&!this.g&&ai(this.f,a,c))}}};
m.Sa=function(a,b){this.j&&!this.g&&ai(this.f,a,this.ea(a,b))};
m.ea=function(a,b){if(null!=b)return{value:b}};
function ci(a,b){b in a.h&&(a.removeEventListener(b,a.h[b]),delete a.h[b])}
m.o=function(){var a=this.f;a.g||Jd(a.f,"command",this.ra,this);this.f=null;for(var b in this.h)ci(this,b);N.prototype.o.call(this)};function fi(a,b){bi.call(this,b);this.i=a;this.start()}
u(fi,bi);fi.prototype.addEventListener=function(a,b){this.i.addEventListener(a,b)};
fi.prototype.removeEventListener=function(a,b){this.i.removeEventListener(a,b)};
function di(a,b){switch(a){case "loadVideoById":return b=Xh(b),[b];case "cueVideoById":return b=Xh(b),[b];case "loadVideoByPlayerVars":return[b];case "cueVideoByPlayerVars":return[b];case "loadPlaylist":return b=Yh(b),[b];case "cuePlaylist":return b=Yh(b),[b];case "seekTo":return[b.seconds,b.allowSeekAhead];case "playVideoAt":return[b.index];case "setVolume":return[b.volume];case "setPlaybackQuality":return[b.suggestedQuality];case "setPlaybackRate":return[b.suggestedRate];case "setLoop":return[b.loopPlaylists];
case "setShuffle":return[b.shufflePlaylist];case "getOptions":return[b.module];case "getOption":return[b.module,b.option];case "setOption":return[b.module,b.option,b.value];case "handleGlobalKeyDown":return[b.keyCode,b.shiftKey,b.ctrlKey,b.altKey,b.metaKey,b.key,b.code]}return[]}
function ei(a,b){switch(a){case "isMuted":return{muted:b};case "getVolume":return{volume:b};case "getPlaybackRate":return{playbackRate:b};case "getAvailablePlaybackRates":return{availablePlaybackRates:b};case "getVideoLoadedFraction":return{videoLoadedFraction:b};case "getPlayerState":return{playerState:b};case "getCurrentTime":return{currentTime:b};case "getPlaybackQuality":return{playbackQuality:b};case "getAvailableQualityLevels":return{availableQualityLevels:b};case "getDuration":return{duration:b};
case "getVideoUrl":return{videoUrl:b};case "getVideoEmbedCode":return{videoEmbedCode:b};case "getPlaylist":return{playlist:b};case "getPlaylistIndex":return{playlistIndex:b};case "getOptions":return{options:b};case "getOption":return{option:b}}}
fi.prototype.ea=function(a,b){switch(a){case "onReady":return;case "onStateChange":return{playerState:b};case "onPlaybackQualityChange":return{playbackQuality:b};case "onPlaybackRateChange":return{playbackRate:b};case "onError":return{errorCode:b}}return bi.prototype.ea.call(this,a,b)};
fi.prototype.o=function(){bi.prototype.o.call(this);delete this.i};function gi(a,b,c){N.call(this);var d=this;c=c||R("POST_MESSAGE_ORIGIN",void 0)||window.document.location.protocol+"//"+window.document.location.hostname;this.h=b||null;this.w="*";this.i=c;this.sessionId=null;this.channel="widget";this.B=!!a;this.m=function(e){a:if(!("*"!=d.i&&e.origin!=d.i||d.h&&e.source!=d.h||"string"!==typeof e.data)){try{var f=JSON.parse(e.data)}catch(g){break a}if(!(null==f||d.B&&(d.sessionId&&d.sessionId!=f.id||d.channel&&d.channel!=f.channel))&&f)switch(f.event){case "listening":"null"!=
e.origin&&(d.i=d.w=e.origin);d.h=e.source;d.sessionId=f.id;d.f&&(d.f(),d.f=null);break;case "command":d.j&&(!d.l||0<=Ia(d.l,f.func))&&d.j(f.func,f.args,e.origin)}}};
this.l=this.f=this.j=null;window.addEventListener("message",this.m)}
u(gi,N);gi.prototype.sendMessage=function(a,b){var c=b||this.h;if(c){this.sessionId&&(a.id=this.sessionId);this.channel&&(a.channel=this.channel);try{var d=JSON.stringify(a);c.postMessage(d,this.w)}catch(e){ke(e)}}};
gi.prototype.o=function(){window.removeEventListener("message",this.m);N.prototype.o.call(this)};function hi(){var a=this.g=new gi(!!R("WIDGET_ID_ENFORCE")),b=B(this.Pa,this);a.j=b;a.l=null;this.g.channel="widget";if(a=R("WIDGET_ID"))this.g.sessionId=a;this.i=[];this.l=!1;this.j={}}
m=hi.prototype;m.Pa=function(a,b,c){"addEventListener"==a&&b?(a=b[0],this.j[a]||"onReady"==a||(this.addEventListener(a,ii(this,a)),this.j[a]=!0)):this.ma(a,b,c)};
m.ma=function(){};
function ii(a,b){return B(function(c){this.sendMessage(b,c)},a)}
m.addEventListener=function(){};
m.za=function(){this.l=!0;this.sendMessage("initialDelivery",this.fa());this.sendMessage("onReady");H(this.i,this.sa,this);this.i=[]};
m.fa=function(){return null};
function ji(a,b){a.sendMessage("infoDelivery",b)}
m.sa=function(a){this.l?this.g.sendMessage(a):this.i.push(a)};
m.sendMessage=function(a,b){this.sa({event:a,info:void 0==b?null:b})};
m.dispose=function(){this.g=null};function ki(a){hi.call(this);this.f=a;this.h=[];this.addEventListener("onReady",B(this.Na,this));this.addEventListener("onVideoProgress",B(this.Wa,this));this.addEventListener("onVolumeChange",B(this.Xa,this));this.addEventListener("onApiChange",B(this.Ra,this));this.addEventListener("onPlaybackQualityChange",B(this.Ta,this));this.addEventListener("onPlaybackRateChange",B(this.Ua,this));this.addEventListener("onStateChange",B(this.Va,this));this.addEventListener("onWebglSettingsChanged",B(this.Ya,
this))}
u(ki,hi);m=ki.prototype;m.ma=function(a,b,c){if(this.f.isExternalMethodAvailable(a,c)){b=b||[];if(0<b.length&&Vh(a)){var d=b;if(ya(d[0])&&!Array.isArray(d[0]))d=d[0];else{var e={};switch(a){case "loadVideoById":case "cueVideoById":e=Xh.apply(window,d);break;case "loadVideoByUrl":case "cueVideoByUrl":e=Wh.apply(window,d);break;case "loadPlaylist":case "cuePlaylist":e=Yh.apply(window,d)}d=e}b.length=1;b[0]=d}this.f.handleExternalCall(a,b,c);Vh(a)&&ji(this,this.fa())}};
m.Na=function(){var a=B(this.za,this);this.g.f=a};
m.addEventListener=function(a,b){this.h.push({eventType:a,listener:b});this.f.addEventListener(a,b)};
m.fa=function(){if(!this.f)return null;var a=this.f.getApiInterface();Na(a,"getVideoData");for(var b={apiInterface:a},c=0,d=a.length;c<d;c++){var e=a[c];if(0===e.search("get")||0===e.search("is")){var f=0;0===e.search("get")?f=3:0===e.search("is")&&(f=2);f=e.charAt(f).toLowerCase()+e.substr(f+1);try{var g=this.f[e]();b[f]=g}catch(h){}}}b.videoData=this.f.getVideoData();b.currentTimeLastUpdated_=C()/1E3;return b};
m.Va=function(a){a={playerState:a,currentTime:this.f.getCurrentTime(),duration:this.f.getDuration(),videoData:this.f.getVideoData(),videoStartBytes:0,videoBytesTotal:this.f.getVideoBytesTotal(),videoLoadedFraction:this.f.getVideoLoadedFraction(),playbackQuality:this.f.getPlaybackQuality(),availableQualityLevels:this.f.getAvailableQualityLevels(),currentTimeLastUpdated_:C()/1E3,playbackRate:this.f.getPlaybackRate(),mediaReferenceTime:this.f.getMediaReferenceTime()};this.f.getVideoUrl&&(a.videoUrl=
this.f.getVideoUrl());this.f.getVideoContentRect&&(a.videoContentRect=this.f.getVideoContentRect());this.f.getProgressState&&(a.progressState=this.f.getProgressState());this.f.getPlaylist&&(a.playlist=this.f.getPlaylist());this.f.getPlaylistIndex&&(a.playlistIndex=this.f.getPlaylistIndex());this.f.getStoryboardFormat&&(a.storyboardFormat=this.f.getStoryboardFormat());ji(this,a)};
m.Ta=function(a){ji(this,{playbackQuality:a})};
m.Ua=function(a){ji(this,{playbackRate:a})};
m.Ra=function(){for(var a=this.f.getOptions(),b={namespaces:a},c=0,d=a.length;c<d;c++){var e=a[c],f=this.f.getOptions(e);b[e]={options:f};for(var g=0,h=f.length;g<h;g++){var k=f[g],l=this.f.getOption(e,k);b[e][k]=l}}this.sendMessage("apiInfoDelivery",b)};
m.Xa=function(){ji(this,{muted:this.f.isMuted(),volume:this.f.getVolume()})};
m.Wa=function(a){a={currentTime:a,videoBytesLoaded:this.f.getVideoBytesLoaded(),videoLoadedFraction:this.f.getVideoLoadedFraction(),currentTimeLastUpdated_:C()/1E3,playbackRate:this.f.getPlaybackRate(),mediaReferenceTime:this.f.getMediaReferenceTime()};this.f.getProgressState&&(a.progressState=this.f.getProgressState());ji(this,a)};
m.Ya=function(){var a={sphericalProperties:this.f.getSphericalProperties()};ji(this,a)};
m.dispose=function(){hi.prototype.dispose.call(this);for(var a=0;a<this.h.length;a++){var b=this.h[a];this.f.removeEventListener(b.eventType,b.listener)}this.h=[]};function li(a,b,c){N.call(this);this.f=a;this.i=c;this.j=X(window,"message",B(this.l,this));this.h=new $h(this,a,b);vc(this,Ea(wc,this.h))}
u(li,N);li.prototype.l=function(a){var b;if(b=!this.g)if(b=a.origin==this.i)a:{b=this.f;do{b:{var c=a.source;do{if(c==b){c=!0;break b}if(c==c.parent)break;c=c.parent}while(null!=c);c=!1}if(c){b=!0;break a}b=b.opener}while(null!=b);b=!1}if(b&&(b=a.data,"string"===typeof b)){try{b=JSON.parse(b)}catch(d){return}b.command&&(c=this.h,c.g||c.j("command",b.command,b.data,a.origin))}};
li.prototype.o=function(){Gf(this.j);this.f=null;N.prototype.o.call(this)};function mi(){var a=Ya(ni),b;return yd(new O(function(c,d){a.onSuccess=function(e){ye(e)?c(e):d(new oi("Request failed, status="+(e&&"status"in e?e.status:-1),"net.badstatus",e))};
a.onError=function(e){d(new oi("Unknown request error","net.unknown",e))};
a.O=function(e){d(new oi("Request timed out","net.timeout",e))};
b=Ie("//googleads.g.doubleclick.net/pagead/id",a)}),function(c){c instanceof zd&&b.abort();
return wd(c)})}
function oi(a,b){G.call(this,a+", errorCode="+b);this.errorCode=b;this.name="PromiseAjaxError"}
u(oi,G);function pi(){this.g=0;this.f=null}
pi.prototype.then=function(a,b,c){return 1===this.g&&a?(a=a.call(c,this.f),rd(a)?a:qi(a)):2===this.g&&b?(a=b.call(c,this.f),rd(a)?a:ri(a)):this};
pi.prototype.getValue=function(){return this.f};
pi.prototype.$goog_Thenable=!0;function ri(a){var b=new pi;a=void 0===a?null:a;b.g=2;b.f=void 0===a?null:a;return b}
function qi(a){var b=new pi;a=void 0===a?null:a;b.g=1;b.f=void 0===a?null:a;return b}
;function si(a){G.call(this,a.message||a.description||a.name);this.isMissing=a instanceof ti;this.isTimeout=a instanceof oi&&"net.timeout"==a.errorCode;this.isCanceled=a instanceof zd}
u(si,G);si.prototype.name="BiscottiError";function ti(){G.call(this,"Biscotti ID is missing from server")}
u(ti,G);ti.prototype.name="BiscottiMissingError";var ni={format:"RAW",method:"GET",timeout:5E3,withCredentials:!0},ui=null;function ee(){if("1"===Sa(be(),"args","privembed"))return wd(Error("Biscotti ID is not available in private embed mode"));ui||(ui=yd(mi().then(vi),function(a){return wi(2,a)}));
return ui}
function vi(a){a=a.responseText;if(0!=a.lastIndexOf(")]}'",0))throw new ti;a=JSON.parse(a.substr(4));if(1<(a.type||1))throw new ti;a=a.id;fe(a);ui=qi(a);xi(18E5,2);return a}
function wi(a,b){var c=new si(b);fe("");ui=ri(c);0<a&&xi(12E4,a-1);throw c;}
function xi(a,b){T(function(){yd(mi().then(vi,function(c){return wi(b,c)}),ua)},a)}
function yi(){try{var a=z("yt.ads.biscotti.getId_");return a?a():ee()}catch(b){return wd(b)}}
;function zi(a){if("1"!==Sa(be(),"args","privembed")){a&&de();try{yi().then(function(){},function(){}),T(zi,18E5)}catch(b){je(b)}}}
;var Y=z("ytglobal.prefsUserPrefsPrefs_")||{};y("ytglobal.prefsUserPrefsPrefs_",Y,void 0);function Ai(){this.f=R("ALT_PREF_COOKIE_NAME","PREF");var a=cc.get(""+this.f,void 0);if(a){a=decodeURIComponent(a).split("&");for(var b=0;b<a.length;b++){var c=a[b].split("="),d=c[0];(c=c[1])&&(Y[d]=c.toString())}}}
m=Ai.prototype;m.get=function(a,b){Bi(a);Ci(a);var c=void 0!==Y[a]?Y[a].toString():null;return null!=c?c:b?b:""};
m.set=function(a,b){Bi(a);Ci(a);if(null==b)throw Error("ExpectedNotNull");Y[a]=b.toString()};
m.remove=function(a){Bi(a);Ci(a);delete Y[a]};
m.save=function(){Yf(this.f,this.dump(),63072E3)};
m.clear=function(){for(var a in Y)delete Y[a]};
m.dump=function(){var a=[],b;for(b in Y)a.push(b+"="+encodeURIComponent(String(Y[b])));return a.join("&")};
function Ci(a){if(/^f([1-9][0-9]*)$/.test(a))throw Error("ExpectedRegexMatch: "+a);}
function Bi(a){if(!/^\w+$/.test(a))throw Error("ExpectedRegexMismatch: "+a);}
function Di(a){a=void 0!==Y[a]?Y[a].toString():null;return null!=a&&/^[A-Fa-f0-9]+$/.test(a)?parseInt(a,16):null}
va(Ai);function Ei(a,b){for(var c=[],d=1;d<arguments.length;++d)c[d-1]=arguments[d];if(!Fi(a)||c.some(function(e){return!Fi(e)}))throw Error("Only objects may be merged.");
c=p(c);for(d=c.next();!d.done;d=c.next())Gi(a,d.value);return a}
function Gi(a,b){for(var c in b)if(Fi(b[c])){if(c in a&&!Fi(a[c]))throw Error("Cannot merge an object into a non-object.");c in a||(a[c]={});Gi(a[c],b[c])}else if(Hi(b[c])){if(c in a&&!Hi(a[c]))throw Error("Cannot merge an array into a non-array.");c in a||(a[c]=[]);Ii(a[c],b[c])}else a[c]=b[c];return a}
function Ii(a,b){for(var c=p(b),d=c.next();!d.done;d=c.next())d=d.value,Fi(d)?a.push(Gi({},d)):Hi(d)?a.push(Ii([],d)):a.push(d);return a}
function Fi(a){return"object"===typeof a&&!Array.isArray(a)}
function Hi(a){return"object"===typeof a&&Array.isArray(a)}
;function Ji(a,b){eh.call(this,1,arguments)}
u(Ji,eh);function Ki(a,b){eh.call(this,1,arguments)}
u(Ki,eh);var Li=new fh("aft-recorded",Ji),Mi=new fh("timing-sent",Ki);var Ni=window;function Oi(){this.timing={};this.clearResourceTimings=function(){};
this.webkitClearResourceTimings=function(){};
this.mozClearResourceTimings=function(){};
this.msClearResourceTimings=function(){};
this.oClearResourceTimings=function(){}}
var Pi=Ni.performance||Ni.mozPerformance||Ni.msPerformance||Ni.webkitPerformance||new Oi;var Qi=!1;B(Pi.clearResourceTimings||Pi.webkitClearResourceTimings||Pi.mozClearResourceTimings||Pi.msClearResourceTimings||Pi.oClearResourceTimings||ua,Pi);function Ri(a){var b=Si(a);if(b.aft)return b.aft;a=R((a||"")+"TIMING_AFT_KEYS",["ol"]);for(var c=a.length,d=0;d<c;d++){var e=b[a[d]];if(e)return e}return NaN}
function Ti(a){var b;(b=z("ytcsi."+(a||"")+"data_"))||(b={tick:{},info:{}},D("ytcsi."+(a||"")+"data_",b));return b}
function Ui(a){a=Ti(a);a.info||(a.info={});return a.info}
function Si(a){a=Ti(a);a.tick||(a.tick={});return a.tick}
function Vi(a){var b=Ti(a).nonce;b||(b=Qg(),Ti(a).nonce=b);return b}
function Wi(a){var b=Si(a||""),c=Ri(a);c&&!Qi&&(kh(Li,new Ji(Math.round(c-b._start),a)),Qi=!0)}
;function Xi(){var a=z("ytcsi.debug");a||(a=[],y("ytcsi.debug",a,void 0),y("ytcsi.reference",{},void 0));return a}
function Yi(a){a=a||"";var b=z("ytcsi.reference");b||(Xi(),b=z("ytcsi.reference"));if(b[a])return b[a];var c=Xi(),d={timerName:a,info:{},tick:{},span:{}};c.push(d);return b[a]=d}
;var Zi=z("ytLoggingLatencyUsageStats_")||{};y("ytLoggingLatencyUsageStats_",Zi,void 0);function $i(){this.f=0}
function aj(){$i.instance||($i.instance=new $i);return $i.instance}
$i.prototype.tick=function(a,b,c){bj(this,"tick_"+a+"_"+b)||eg("latencyActionTicked",{tickName:a,clientActionNonce:b},{timestamp:c})};
$i.prototype.info=function(a,b){var c=Object.keys(a).join("");bj(this,"info_"+c+"_"+b)||(a.clientActionNonce=b,eg("latencyActionInfo",a))};
$i.prototype.span=function(a,b){var c=Object.keys(a).join("");bj(this,"span_"+c+"_"+b)||(a.clientActionNonce=b,eg("latencyActionSpan",a))};
function bj(a,b){Zi[b]=Zi[b]||{count:0};var c=Zi[b];c.count++;c.time=V();a.f||(a.f=Lf(function(){var d=V(),e;for(e in Zi)Zi[e]&&6E4<d-Zi[e].time&&delete Zi[e];a&&(a.f=0)},0,5E3));
return 5<c.count?(6===c.count&&1>1E5*Math.random()&&(c=new fg("CSI data exceeded logging limit with key",b),0===b.indexOf("info")?ig(c):jg(c)),!0):!1}
;var Z={},cj=(Z.ad_allowed="adTypesAllowed",Z.yt_abt="adBreakType",Z.ad_cpn="adClientPlaybackNonce",Z.ad_docid="adVideoId",Z.yt_ad_an="adNetworks",Z.ad_at="adType",Z.browse_id="browseId",Z.p="httpProtocol",Z.t="transportProtocol",Z.cpn="clientPlaybackNonce",Z.ccs="creatorInfo.creatorCanaryState",Z.cseg="creatorInfo.creatorSegment",Z.csn="clientScreenNonce",Z.docid="videoId",Z.GetHome_rid="requestIds",Z.GetSearch_rid="requestIds",Z.GetPlayer_rid="requestIds",Z.GetWatchNext_rid="requestIds",Z.GetBrowse_rid=
"requestIds",Z.GetLibrary_rid="requestIds",Z.is_continuation="isContinuation",Z.is_nav="isNavigation",Z.b_p="kabukiInfo.browseParams",Z.is_prefetch="kabukiInfo.isPrefetch",Z.is_secondary_nav="kabukiInfo.isSecondaryNav",Z.prev_browse_id="kabukiInfo.prevBrowseId",Z.query_source="kabukiInfo.querySource",Z.voz_type="kabukiInfo.vozType",Z.yt_lt="loadType",Z.mver="creatorInfo.measurementVersion",Z.yt_ad="isMonetized",Z.nr="webInfo.navigationReason",Z.nrsu="navigationRequestedSameUrl",Z.ncnp="webInfo.nonPreloadedNodeCount",
Z.pnt="performanceNavigationTiming",Z.prt="playbackRequiresTap",Z.plt="playerInfo.playbackType",Z.pis="playerInfo.playerInitializedState",Z.paused="playerInfo.isPausedOnLoad",Z.yt_pt="playerType",Z.fmt="playerInfo.itag",Z.yt_pl="watchInfo.isPlaylist",Z.yt_pre="playerInfo.preloadType",Z.yt_ad_pr="prerollAllowed",Z.pa="previousAction",Z.yt_red="isRedSubscriber",Z.rce="mwebInfo.responseContentEncoding",Z.scrh="screenHeight",Z.scrw="screenWidth",Z.st="serverTimeMs",Z.aq="tvInfo.appQuality",Z.br_trs="tvInfo.bedrockTriggerState",
Z.kebqat="kabukiInfo.earlyBrowseRequestInfo.abandonmentType",Z.kebqa="kabukiInfo.earlyBrowseRequestInfo.adopted",Z.label="tvInfo.label",Z.is_mdx="tvInfo.isMdx",Z.preloaded="tvInfo.isPreloaded",Z.upg_player_vis="playerInfo.visibilityState",Z.query="unpluggedInfo.query",Z.upg_chip_ids_string="unpluggedInfo.upgChipIdsString",Z.yt_vst="videoStreamType",Z.vph="viewportHeight",Z.vpw="viewportWidth",Z.yt_vis="isVisible",Z.rcl="mwebInfo.responseContentLength",Z.GetSettings_rid="requestIds",Z.GetTrending_rid=
"requestIds",Z.GetMusicSearchSuggestions_rid="requestIds",Z.REQUEST_ID="requestIds",Z),dj="isContinuation isNavigation kabukiInfo.earlyBrowseRequestInfo.adopted kabukiInfo.isPrefetch kabukiInfo.isSecondaryNav isMonetized navigationRequestedSameUrl performanceNavigationTiming playerInfo.isPausedOnLoad prerollAllowed isRedSubscriber tvInfo.isMdx tvInfo.isPreloaded isVisible watchInfo.isPlaylist playbackRequiresTap".split(" "),ej={},fj=(ej.ccs="CANARY_STATE_",ej.mver="MEASUREMENT_VERSION_",ej.pis="PLAYER_INITIALIZED_STATE_",
ej.yt_pt="LATENCY_PLAYER_",ej.pa="LATENCY_ACTION_",ej.yt_vst="VIDEO_STREAM_TYPE_",ej),gj="all_vc ap c cver cbrand cmodel cplatform ctheme ei l_an l_mm plid srt yt_fss yt_li vpst vpni2 vpil2 icrc icrt pa GetAccountOverview_rid GetHistory_rid cmt d_vpct d_vpnfi d_vpni nsru pc pfa pfeh pftr pnc prerender psc rc start tcrt tcrc ssr vpr vps yt_abt yt_fn yt_fs yt_pft yt_pre yt_pt yt_pvis ytu_pvis yt_ref yt_sts tds".split(" ");function hj(a){return!!R("FORCE_CSI_ON_GEL",!1)||S("csi_on_gel")||!!Ti(a).useGel}
function ij(a){a=Ti(a);if(!("gel"in a))a.gel={gelTicks:{},gelInfos:{}};else if(a.gel){var b=a.gel;b.gelInfos||(b.gelInfos={});b.gelTicks||(b.gelTicks={})}return a.gel}
;function jj(a,b,c){if(null!==b)if(Ui(c)[a]=b,hj(c)){var d=b;b=ij(c);if(b.gelInfos)b.gelInfos["info_"+a]=!0;else{var e={};b.gelInfos=(e["info_"+a]=!0,e)}if(a in cj){if(a.match("_rid")){var f=a.split("_rid")[0];a="REQUEST_ID"}b=cj[a];0<=Ia(dj,b)&&(d=!!d);a in fj&&"string"===typeof d&&(d=fj[a]+d.toUpperCase());a=d;d=b.split(".");for(var g=e={},h=0;h<d.length-1;h++){var k=d[h];g[k]={};g=g[k]}g[d[d.length-1]]="requestIds"===b?[{id:a,endpoint:f}]:a;f=Ei({},e)}else 0<=Ia(gj,a)||ig(new fg("Unknown label logged with GEL CSI",
a)),f=void 0;f&&hj(c)&&(b=Yi(c||""),Ei(b.info,f),b=ij(c),"gelInfos"in b||(b.gelInfos={}),Ei(b.gelInfos,f),c=Vi(c),aj().info(f,c))}else Yi(c||"").info[a]=b}
function kj(a,b,c){var d=Si(c);if(S("use_first_tick")&&lj(a,c))return d[a];if(!b&&"_"!==a[0]){var e=a;Pi.mark&&(0==e.lastIndexOf("mark_",0)||(e="mark_"+e),c&&(e+=" ("+c+")"),Pi.mark(e))}e=b||V();d[a]=e;e=ij(c);e.gelTicks&&(e.gelTicks["tick_"+a]=!0);c||b||V();if(hj(c)){Yi(c||"").tick[a]=b||V();e=Vi(c);if("_start"===a){var f=aj();bj(f,"baseline_"+e)||eg("latencyActionBaselined",{clientActionNonce:e},{timestamp:b})}else aj().tick(a,e,b);Wi(c);e=!0}else e=!1;if(!e){if(!z("yt.timing."+(c||"")+"pingSent_")&&
(f=R((c||"")+"TIMING_ACTION",void 0),e=Si(c),z("ytglobal.timing"+(c||"")+"ready_")&&f&&lj("_start")&&Ri(c)))if(Wi(c),c)mj(c);else{f=!0;var g=R("TIMING_WAIT",[]);if(g.length)for(var h=0,k=g.length;h<k;++h)if(!(g[h]in e)){f=!1;break}f&&mj(c)}Yi(c||"").tick[a]=b||V()}return d[a]}
function lj(a,b){var c=Si(b);return a in c}
function mj(a){if(!hj(a)){var b=Si(a),c=Ui(a),d=b._start,e=R("CSI_SERVICE_NAME","youtube"),f={v:2,s:e,action:R((a||"")+"TIMING_ACTION",void 0)},g=c.srt;void 0!==b.srt&&delete c.srt;b.aft=Ri(a);var h=Si(a),k=h.pbr,l=h.vc;h=h.pbs;k&&l&&h&&k<l&&l<h&&Ui(a).yt_pvis&&"youtube"===e&&(jj("yt_lt","hot_bg",a),e=b.vc,k=b.pbs,delete b.aft,c.aft=Math.round(k-e));for(var n in c)"_"!==n.charAt(0)&&(f[n]=c[n]);b.ps=V();n={};e=[];for(var r in b)"_"!==r.charAt(0)&&(k=Math.round(b[r]-d),n[r]=k,e.push(r+"."+k));f.rt=
e.join(",");b=!!c.ap;S("debug_csi_data")&&(c=z("yt.timing.csiData"),c||(c=[],D("yt.timing.csiData",c)),c.push({page:location.href,time:new Date,args:f}));c="";for(var w in f)f.hasOwnProperty(w)&&(c+="&"+w+"="+f[w]);f="/csi_204?"+c.substring(1);if(window.navigator&&window.navigator.sendBeacon&&b){var t=void 0===t?"":t;Te(f,t)||Qe(f,void 0,void 0,void 0,t)}else Qe(f);y("yt.timing."+(a||"")+"pingSent_",!0,void 0);kh(Mi,new Ki(n.aft+(Number(g)||0),a))}}
if(S("overwrite_polyfill_on_logging_lib_loaded")){var nj=window;nj.ytcsi&&(nj.ytcsi.info=jj,nj.ytcsi.tick=kj)};var oj=null,pj=null,qj=null,rj={};function sj(a){var b=a.id;a=a.ve_type;var c=Sg++;a=new Tg({veType:a,veCounter:c,elementIndex:void 0,dataElement:void 0,youtubeData:void 0});rj[b]=a;b=$g();c=Yg();b&&c&&uh(b,c,[a])}
function tj(a){var b=a.csn;a=a.root_ve_type;if(b&&a&&(ch(b,a),a=Yg()))for(var c in rj){var d=rj[c];d&&uh(b,a,[d])}}
function uj(a){rj[a.id]=new Tg({trackingParams:a.tracking_params})}
function vj(a){var b=$g(),c=rj[a.id];if(b&&c){a=S("use_default_events_client")?void 0:dg;c={csn:b,ve:Ug(c),gestureType:"INTERACTION_LOGGING_GESTURE_TYPE_GENERIC_CLICK"};var d={ca:bh(b),P:b};"UNDEFINED_CSN"==b?vh("visualElementGestured",c,d):a?Tf("visualElementGestured",c,a,d):eg("visualElementGestured",c,d)}}
function wj(a){a=a.ids;var b=$g();if(b)for(var c=0;c<a.length;c++){var d=rj[a[c]];if(d){var e=b,f=S("use_default_events_client")?void 0:dg;d={csn:e,ve:Ug(d),eventType:1};var g={ca:bh(e),P:e};"UNDEFINED_CSN"==e?vh("visualElementShown",d,g):f?Tf("visualElementShown",d,f,g):eg("visualElementShown",d,g)}}}
;y("yt.setConfig",Q,void 0);y("yt.config.set",Q,void 0);y("yt.setMsg",ng,void 0);y("yt.msgs.set",ng,void 0);y("yt.logging.errors.log",lg,void 0);
y("writeEmbed",function(){var a=R("PLAYER_CONFIG",void 0);zi(!0);"gvn"==a.args.ps&&(document.body.style.backgroundColor="transparent");var b=document.referrer,c=R("POST_MESSAGE_ORIGIN");window!=window.top&&b&&b!=document.URL&&(a.args.loaderUrl=b);R("LIGHTWEIGHT_AUTOPLAY")&&(a.args.autoplay="1");b="player";var d=void 0===d?!0:d;b="string"===typeof b?gc(b):b;var e=Th+"_"+za(b),f=Sh[e];f&&d?a&&a.args&&a.args.fflags&&a.args.fflags.includes("web_player_remove_playerproxy=true")?f.api.loadVideoByPlayerVars(a.args||
null):f.loadNewVideoConfig(a):(f=new Dh(b,e,a,void 0),Sh[e]=f,af("player-added",f.api),vc(f,Ea(Uh,f)));a=f.api;oj=a;a.addEventListener("onScreenChanged",tj);a.addEventListener("onLogClientVeCreated",sj);a.addEventListener("onLogServerVeCreated",uj);a.addEventListener("onLogVeClicked",vj);a.addEventListener("onLogVesShown",wj);d=R("POST_MESSAGE_ID","player");R("ENABLE_JS_API")?qj=new ki(a):R("ENABLE_POST_API")&&"string"===typeof d&&"string"===typeof c&&(pj=new li(window.parent,d,c),qj=new fi(a,pj.h));
c=R("BG_P",void 0);Mg(c)&&(R("BG_I")||R("BG_IU"))&&(Ig=!0,Hg.initialize(R("BG_I",null),R("BG_IU",null),c,Lg,void 0,!!R("BG_CE",!1)));Dg()},void 0);
y("yt.www.watch.ads.restrictioncookie.spr",function(a){Qe(a+"mac_204?action_fcts=1");return!0},void 0);
var xj=ie(function(){kj("ol");var a=Ai.getInstance(),b=!!((Di("f"+(Math.floor(119/31)+1))||0)&67108864),c=1<window.devicePixelRatio;if(document.body&&ad(document.body,"exp-invert-logo"))if(c&&!ad(document.body,"inverted-hdpi")){var d=document.body;if(d.classList)d.classList.add("inverted-hdpi");else if(!ad(d,"inverted-hdpi")){var e=Zc(d);$c(d,e+(0<e.length?" inverted-hdpi":"inverted-hdpi"))}}else!c&&ad(document.body,"inverted-hdpi")&&bd();b!=c&&(b="f"+(Math.floor(119/31)+1),d=Di(b)||0,d=c?d|67108864:
d&-67108865,0==d?delete Y[b]:(c=d.toString(16),Y[b]=c.toString()),a.save())}),yj=ie(function(){var a=oj;
a&&a.sendAbandonmentPing&&a.sendAbandonmentPing();R("PL_ATT")&&Hg.dispose();a=0;for(var b=Bg.length;a<b;a++){var c=Bg[a];if(!isNaN(c)){var d=z("yt.scheduler.instance.cancelJob");d?d(c):U(c)}}Bg.length=0;zg("//static.doubleclick.net/instream/ad_status.js");Cg=!1;Q("DCLKSTAT",0);xc(qj,pj);if(a=oj)a.removeEventListener("onScreenChanged",tj),a.removeEventListener("onLogClientVeCreated",sj),a.removeEventListener("onLogServerVeCreated",uj),a.removeEventListener("onLogVeClicked",vj),a.removeEventListener("onLogVesShown",
wj),a.destroy();rj={}});
window.addEventListener?(window.addEventListener("load",xj),window.addEventListener("unload",yj)):window.attachEvent&&(window.attachEvent("onload",xj),window.attachEvent("onunload",yj));D("yt.abuse.player.botguardInitialized",z("yt.abuse.player.botguardInitialized")||Ng);D("yt.abuse.player.invokeBotguard",z("yt.abuse.player.invokeBotguard")||Og);D("yt.abuse.dclkstatus.checkDclkStatus",z("yt.abuse.dclkstatus.checkDclkStatus")||Eg);D("yt.player.exports.navigate",z("yt.player.exports.navigate")||dh);
D("yt.util.activity.init",z("yt.util.activity.init")||Of);D("yt.util.activity.getTimeSinceActive",z("yt.util.activity.getTimeSinceActive")||Rf);D("yt.util.activity.setTimestamp",z("yt.util.activity.setTimestamp")||Pf);}).call(this);
