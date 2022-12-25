// https://blog.csdn.net/qq_33674679/article/details/128128291?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-5-128128291-blog-128240291.pc_relevant_3mothn_strategy_and_data_recovery&spm=1001.2101.3001.4242.4&utm_relevant_index=8
// 添加超链接、视频
import { Quill } from '@vueup/vue-quill'
// 源码中是import直接倒入，这里要用Quill.import引入
const BlockEmbed = Quill.import('blots/block/embed')
const Link = Quill.import('formats/link')
 
const ATTRIBUTES = ['height', 'width']
 
class quillTool extends BlockEmbed {
    static create(value) {
        const node = super.create(value)
        // 添加video标签所需的属性
        node.setAttribute('controls', 'controls')
        node.setAttribute('type', 'video/mp4')
        node.setAttribute('src', this.sanitize(value))
        return node
    }
 
    static formats(domNode) {
        return ATTRIBUTES.reduce((formats, attribute) => {
            if (domNode.hasAttribute(attribute)) {
                formats[attribute] = domNode.getAttribute(attribute)
            }
            return formats
        }, {})
    }
 
    static sanitize(url) {
        return Link.sanitize(url)
    }
 
    static value(domNode) {
        return domNode.getAttribute('src')
    }
 
    format(name, value) {
        if (ATTRIBUTES.indexOf(name) > -1) {
            if (value) {
                this.domNode.setAttribute(name, value)
            } else {
                this.domNode.removeAttribute(name)
            }
        } else {
            super.format(name, value)
        }
    }
 
    html() {
        const { video } = this.value()
        return `<a href="${video}">${video}</a>`
    }
}
quillTool.blotName = 'video' // 这里不用改，楼主不用iframe，直接替换掉原来，如果需要也可以保留原来的，这里用个新的blot
quillTool.className = 'ql-video'
quillTool.tagName = 'video' // 用video标签替换iframe
 
export default quillTool