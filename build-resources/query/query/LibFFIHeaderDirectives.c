#include <stdio.h>
#include <stddef.h>
#include <memory.h>

#include <svm_libffi.h>

int LibFFIHeaderDirectives() {
    printf("NativeCodeInfo:LibFFIHeaderDirectives:ConstantInfo:FFI_DEFAULT_ABI:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(FFI_DEFAULT_ABI)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:ConstantInfo:FFI_DEFAULT_ABI:PropertyInfo:signedness=$%s$\n", ((FFI_DEFAULT_ABI>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:LibFFIHeaderDirectives:ConstantInfo:FFI_DEFAULT_ABI:PropertyInfo:value=%lX\n", ((unsigned long)FFI_DEFAULT_ABI));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:ConstantInfo:FFI_OK:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(FFI_OK)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:ConstantInfo:FFI_OK:PropertyInfo:signedness=$%s$\n", ((FFI_OK>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:LibFFIHeaderDirectives:ConstantInfo:FFI_OK:PropertyInfo:value=%lX\n", ((unsigned long)FFI_OK));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:PointerToInfo:ffi_type_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(ffi_type*)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_arg:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(ffi_arg)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_cif:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(ffi_cif)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_cif:StructFieldInfo:arg_types:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((ffi_cif *) 0)->arg_types)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_cif:StructFieldInfo:arg_types:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(ffi_cif, arg_types)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_cif:StructFieldInfo:nargs:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((ffi_cif *) 0)->nargs)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_cif:StructFieldInfo:nargs:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(ffi_cif, nargs)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        ffi_cif fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.nargs = all_bits_set;
        is_unsigned = fieldHolder.nargs > 0;
        printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_cif:StructFieldInfo:nargs:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_closure:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(ffi_closure)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_type:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(ffi_type)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_type:StructFieldInfo:alignment:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((ffi_type *) 0)->alignment)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_type:StructFieldInfo:alignment:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(ffi_type, alignment)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        ffi_type fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.alignment = all_bits_set;
        is_unsigned = fieldHolder.alignment > 0;
        printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_type:StructFieldInfo:alignment:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_type:StructFieldInfo:size:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((ffi_type *) 0)->size)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_type:StructFieldInfo:size:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(ffi_type, size)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        ffi_type fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.size = all_bits_set;
        is_unsigned = fieldHolder.size > 0;
        printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:ffi_type:StructFieldInfo:size:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(struct __TruffleNativeAPI)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:exceptionCheck:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleNativeAPI *) 0)->exceptionCheck)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:exceptionCheck:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleNativeAPI, exceptionCheck)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:getClosureObject:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleNativeAPI *) 0)->getClosureObject)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:getClosureObject:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleNativeAPI, getClosureObject)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:getTruffleContext:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleNativeAPI *) 0)->getTruffleContext)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:getTruffleContext:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleNativeAPI, getTruffleContext)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:isSameObject:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleNativeAPI *) 0)->isSameObject)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:isSameObject:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleNativeAPI, isSameObject)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:newClosureRef:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleNativeAPI *) 0)->newClosureRef)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:newClosureRef:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleNativeAPI, newClosureRef)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:newObjectRef:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleNativeAPI *) 0)->newObjectRef)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:newObjectRef:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleNativeAPI, newObjectRef)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:releaseAndReturn:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleNativeAPI *) 0)->releaseAndReturn)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:releaseAndReturn:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleNativeAPI, releaseAndReturn)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:releaseClosureRef:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleNativeAPI *) 0)->releaseClosureRef)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:releaseClosureRef:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleNativeAPI, releaseClosureRef)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:releaseObjectRef:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleNativeAPI *) 0)->releaseObjectRef)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleNativeAPI:StructFieldInfo:releaseObjectRef:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleNativeAPI, releaseObjectRef)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleThreadAPI:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(struct __TruffleThreadAPI)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleThreadAPI:StructFieldInfo:attachCurrentThread:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleThreadAPI *) 0)->attachCurrentThread)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleThreadAPI:StructFieldInfo:attachCurrentThread:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleThreadAPI, attachCurrentThread)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleThreadAPI:StructFieldInfo:detachCurrentThread:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleThreadAPI *) 0)->detachCurrentThread)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleThreadAPI:StructFieldInfo:detachCurrentThread:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleThreadAPI, detachCurrentThread)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleThreadAPI:StructFieldInfo:getTruffleEnv:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct __TruffleThreadAPI *) 0)->getTruffleEnv)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:struct___TruffleThreadAPI:StructFieldInfo:getTruffleEnv:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(struct __TruffleThreadAPI, getTruffleEnv)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_cif_data:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(svm_cif_data)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_cif_data:StructFieldInfo:args:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_cif_data *) 0)->args)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_cif_data:StructFieldInfo:args:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_cif_data, args)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_cif_data:StructFieldInfo:cif:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_cif_data *) 0)->cif)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_cif_data:StructFieldInfo:cif:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_cif_data, cif)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(svm_closure_data)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:StructFieldInfo:envArgIdx:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_closure_data *) 0)->envArgIdx)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:StructFieldInfo:envArgIdx:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_closure_data, envArgIdx)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        svm_closure_data fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.envArgIdx = all_bits_set;
        is_unsigned = fieldHolder.envArgIdx > 0;
        printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:StructFieldInfo:envArgIdx:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:StructFieldInfo:ffiClosure:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_closure_data *) 0)->ffiClosure)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:StructFieldInfo:ffiClosure:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_closure_data, ffiClosure)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:StructFieldInfo:isolate:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_closure_data *) 0)->isolate)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:StructFieldInfo:isolate:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_closure_data, isolate)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:StructFieldInfo:nativeClosureHandle:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_closure_data *) 0)->nativeClosureHandle)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_closure_data:StructFieldInfo:nativeClosureHandle:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_closure_data, nativeClosureHandle)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(svm_truffle_context)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:contextHandle:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_truffle_context *) 0)->contextHandle)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:contextHandle:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_truffle_context, contextHandle)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:functions:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_truffle_context *) 0)->functions)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:functions:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_truffle_context, functions)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:isolate:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_truffle_context *) 0)->isolate)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:isolate:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_truffle_context, isolate)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:nativeAPI:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_truffle_context *) 0)->nativeAPI)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:nativeAPI:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_truffle_context, nativeAPI)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:threadAPI:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_truffle_context *) 0)->threadAPI)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_context:StructFieldInfo:threadAPI:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_truffle_context, threadAPI)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_env:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(svm_truffle_env)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_env:StructFieldInfo:context:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_truffle_env *) 0)->context)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_env:StructFieldInfo:context:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_truffle_env, context)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_env:StructFieldInfo:functions:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_truffle_env *) 0)->functions)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_env:StructFieldInfo:functions:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_truffle_env, functions)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_env:StructFieldInfo:isolateThread:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_truffle_env *) 0)->isolateThread)));
    printf("NativeCodeInfo:LibFFIHeaderDirectives:StructInfo:svm_truffle_env:StructFieldInfo:isolateThread:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_truffle_env, isolateThread)));
    return 0;
}

int main(void) {
    return LibFFIHeaderDirectives();
}
